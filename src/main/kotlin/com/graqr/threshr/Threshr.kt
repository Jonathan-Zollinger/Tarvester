package com.graqr.threshr

import com.graqr.threshr.Utils.getSecureRandomString
import com.graqr.threshr.model.queryparam.Place
import com.graqr.threshr.model.queryparam.TargetStore
import com.graqr.threshr.model.queryparam.Tcin
import com.graqr.threshr.model.redsky.product.Product
import com.graqr.threshr.model.redsky.product.ProductSummaryWithFulfillment
import com.graqr.threshr.model.redsky.product.Search
import com.graqr.threshr.model.redsky.product.plp.search.PlpSearchRoot
import com.graqr.threshr.model.redsky.store.NearbyStores
import com.graqr.threshr.model.redsky.store.Store
import io.micronaut.core.async.annotation.SingleResult
import io.micronaut.http.annotation.Controller

@Controller()
class Threshr (private val threshrClient: ThreshrClient, private val visitorID: String = getSecureRandomString(32)) {


    // ------- product summary queries -------
    /**
     * Query product summaries and their fulfillment options. See [ProductSummaryWithFulfillment]
     *
     * @param targetStore TargetStore object whose inventory is queried for product summaries
     * @param tcin        TCIN object for one or many product ID(s)
     * @return List of product summaries, one for each ID in the tcin object.
     * @throws ThreshrException if no product summaries are returned by the query
     */
    @SingleResult
    @Throws(ThreshrException::class)
    fun fetchProductSummaries(targetStore: TargetStore, tcin: Tcin): List<ProductSummaryWithFulfillment> {
        return threshrClient.getProductSummary(targetStore, tcin).body()?.data!!.productSummaryWithFulfillmentList
    }

    /**
     * Query product summaries and their fulfillment options. See [ProductSummaryWithFulfillment]
     *
     * @param targetStore TargetStore object whose inventory is queried for product summaries
     * @param tcin        single or many string values for product ID(s)
     * @return List of product summaries, one for each ID in the tcin object.
     * @throws ThreshrException if no product summaries are returned by the query
     */
    @SingleResult
    @Throws(ThreshrException::class)
    fun fetchProductSummaries(targetStore: TargetStore, vararg tcin: String): List<ProductSummaryWithFulfillment> {
        return fetchProductSummaries(targetStore, Tcin(tcin.toList()))
    }


    // ------- pdp queries -------
    /**
     * Queries the product details page for a given product at a given store.
     *
     * @param pricingStoreId store identifier
     * @param storeId        store identifier
     * @param tcin           Target's internal product id number. aka 'Target Catalog Identification Number'
     * @return Product object matching the given query
     * @throws ThreshrException if no Product matching given query is found
     */
    @SingleResult
    @Throws(ThreshrException::class)
    fun fetchProductDetails(pricingStoreId: String, storeId: String, tcin: String): Product {
        return threshrClient.getProductDetails(pricingStoreId, storeId, tcin).body()?.data!!.product
    }


    //------- plp queries -------
    /**
     *
     * @param pricingStore  store identifier
     * @param category      Target's internal product category id.
     * @return Search object with non-null product array.
     * May include non-null searchSuggestion string array.
     * May include non-null SearchResponse object.
     * @throws ThreshrException if no Product matching given query is found
     */
    @Throws(ThreshrException::class)
    fun plpQuery(pricingStore: TargetStore, category: String): List<Search> {
        var offset = 0
        val searchList: MutableList<Search> = ArrayList()
        var result: Search
        do {
            result = plpQuery(pricingStore, category, offset)
            searchList.add(result)
            offset++
        } while (result.searchResponse.metadata.totalPages > offset)
        return searchList
    }

    /**
     * This is product listings query with sensible default values for channel, page and visitorId.
     * See[PlpSearchRoot].
     *
     * @param pricingStore store from which the product listings are to be queried.
     * @param category     Target's internal product category id.
     * @return Search object with non-null product array.
     * May include non-null searchSuggestion string array.
     * May include non-null SearchResponse object.
     * @throws ThreshrException if body of HttpResponse providing the Search object is null
     */
    @SingleResult
    @Throws(ThreshrException::class)
    fun plpQuery(pricingStore: TargetStore, category: String, offset: Int): Search {
        return plpQuery(pricingStore.storeId,visitorID,offset,category,"/c/$category",
            when(System.getenv("THRESHR_CHANNEL")) {null -> "WEB" else -> System.getenv("THRESHR_CHANNEL")})
    }

    /**
     * This is the lower level query for product listings. See [PlpSearchRoot].
     *
     * @param pricingStoreId store from which the product listings are to be queried.
     * @param visitorId      id for the visitor. This could be meaningless, but can't be null.
     * @param category       Target's internal product category id.
     * @param page           Seems to be the category value prepended with "/c/"
     * @param channel        communication through which this api is being called. it's always 'WEB'
     * @return Search object with non-null product array.
     * May include non-null searchSuggestion string array.
     * May include non-null SearchResponse object.
     * @throws ThreshrException if body of HttpResponse providing the Search object is null
     */
    @SingleResult
    @Throws(ThreshrException::class)
    fun plpQuery( pricingStoreId: String, visitorId: String, offset: Int, category: String, page: String, channel: String): Search {
        return threshrClient.getProductListings(pricingStoreId, visitorId, offset, category, page, channel).body()?.data!!.search
    }


    //------- stores -------
    /**
     * queries at most 5 stores within 100 miles of a given location
     *
     * @param place Either a zipcode or a city-state pair of strings. see [Place].
     * @return NearbyStores object with a list of store objects
     * @throws ThreshrException if the returned value is null.
     */
    @SingleResult
    @Throws(ThreshrException::class)
    fun getStores(place: Place): NearbyStores {
        return getStores(5, 100, place)
    }

    /**
     * Queries stores relative to a given location
     *
     * @param place  Either a zipcode or a city-state pair of strings. see [Place].
     * @param limit  max store locations to include in returned NearbyStores object.
     * @param within distance from given location to include in search.
     * @return NearbyStores object with a list of store objects
     * @throws ThreshrException if the returned value is null.
     */
    @SingleResult
    @Throws(ThreshrException::class)
    fun getStores(limit: Int, within: Int, place: Place): NearbyStores {
        return threshrClient.getNearbyStores(limit, within, place.zipOrCity).body()?.data!!.nearbyStores
    }

    /**
     * Get Store information by store ID.
     * Assigns sensible default values of 'WEB' and '/c/root' for channel and page parameters.
     *
     * @param storeId target store id
     * @return Store object
     * @throws ThreshrException if body of HttpResponse is null
     */
    @SingleResult
    @Throws(ThreshrException::class)
    fun getStore(storeId: String): Store { return getStore(storeId, "WEB", "root")
    }

    /**
     * Get Store information by store ID.
     *
     * @param storeId target store id
     * @param channel communication through which this api is being called.
     * @param page    source web page on target.com where this api call originates
     * @return Store object
     * @throws ThreshrException if body of HttpResponse is null
     */
    @SingleResult
    @Throws(ThreshrException::class)
    fun getStore(storeId: String?, channel: String?, page: String): Store {
        return threshrClient.getStore(storeId!!, channel!!, page).body()?.data!!.store
    }
}