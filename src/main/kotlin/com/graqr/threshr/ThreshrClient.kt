package com.graqr.threshr

import com.graqr.threshr.model.queryparam.TargetStore
import com.graqr.threshr.model.queryparam.Tcin
import com.graqr.threshr.model.redsky.product.summary.ProductSummaryRoot
import io.micronaut.http.HttpHeaders.ACCEPT
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Header
import io.micronaut.http.client.annotation.Client

@Client("redsky-api")
@Header(name = ACCEPT, value = "text/html," +
        "application/xhtml+xml," +
        "application/xml;q=0.9," +
        "image/avif,image/webp," +
        "image/png," +
        "image/svg+xml," +
        "*/*;q=0.8")
interface ThreshrClient {

    /**
     * Queries target's product summaries from of the given tcins at a given target store.
     * A product summary does not include pricing.
     *
     * @param tcins       tcin ID's for products to query. see {@link Tcin#setTcins(String...)}
     * @param targetStore store from which the product summaries are to be queried.
     */
    @Get("/product_summary_with_fulfillment_v1" +
            "?key=\${threshr.key}" +
            "\${&tcins*}" +
            "\${&targetStore*}" +
            "&CHANNEL=\${threshr.channel}")
    fun getProductSummary(targetStore: TargetStore, tcins: Tcin): HttpResponse<ProductSummaryRoot>
}