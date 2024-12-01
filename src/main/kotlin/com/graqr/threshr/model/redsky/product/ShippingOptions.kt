package com.graqr.threshr.model.redsky.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
data class ShippingOptions(
        @JsonProperty("availability_status")
        val availabilityStatus: String,
        @JsonProperty("loyalty_availability_status")
        val loyaltyAvailabilityStatus: String,
        val services: List<Any>
) {
}
