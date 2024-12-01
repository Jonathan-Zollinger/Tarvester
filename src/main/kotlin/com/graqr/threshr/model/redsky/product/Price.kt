package com.graqr.threshr.model.redsky.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable
import jakarta.annotation.Nullable

@Serdeable
data class Price(
        @JsonProperty("formatted_current_price")
        val formattedCurrentPrice: String,
        @JsonProperty("formatted_current_price_type")
        val formattedCurrentPriceType: String,
        @JsonProperty("reg_retail")
        val regRetail: Double,
        @JsonProperty("formatted_unit_price")
        val formattedUnitPrice: String,
        @JsonProperty("formatted_unit_price_suffix")
        val formattedUnitPriceSuffix: String,
        @JsonProperty("location_id")
        val locationId: Long,
        @Nullable @JsonProperty("current_retail")
        val currentRetail: Double,
        @Nullable @JsonProperty("external_system_id")
        val externalSystemId: String,
        @Nullable @JsonProperty("is_current_price_range")
        val isCurrentPriceRange: Boolean) {
}
