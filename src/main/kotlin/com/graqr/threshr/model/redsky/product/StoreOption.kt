package com.graqr.threshr.model.redsky.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class StoreOption(
        @JsonProperty("search_response_store_type")
        val searchResponseStoreType: String,
        @JsonProperty("location_available_to_promise_quantity")
        val locationAvailableToPromiseQuantity: Double,
        @JsonProperty("location_id")
        val locationId: String,
        val store: Store,
        @JsonProperty("order_pickup")
        val orderPickup: OrderPickup,
        @JsonProperty("in_store_only")
        val inStoreOnly: InStoreOnly) {

}
