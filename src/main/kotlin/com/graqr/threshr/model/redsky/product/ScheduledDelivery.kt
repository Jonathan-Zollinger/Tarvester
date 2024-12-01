package com.graqr.threshr.model.redsky.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Nullable
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class ScheduledDelivery(
        @JsonProperty("is_active")
        val isActive: Boolean,
        @Nullable @JsonProperty("location_available_to_promise_quantity")
        val locationAvailableToPromiseQuantity: Double) {
}
