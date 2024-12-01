package com.graqr.threshr.model.redsky.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Nullable
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class OrderPickup(
        @JsonProperty("availability_status")
        val availabilityStatus: String,
        @Nullable @JsonProperty("pickup_date")
        val pickupDate: String,
        @Nullable @JsonProperty("guest_pick_sla")
        val guestPickSla: Long,
        @Nullable @JsonProperty("location_locale")
        val locationLocale: String) {
}
