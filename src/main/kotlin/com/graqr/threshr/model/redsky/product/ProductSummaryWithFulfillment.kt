package com.graqr.threshr.model.redsky.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Nullable
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class ProductSummaryWithFulfillment(
        @JsonProperty("__typename")
        val typename: String,
        val tcin: String,
        val item: Item,
        @Nullable
        val fulfillment: Fulfillment) {
}
