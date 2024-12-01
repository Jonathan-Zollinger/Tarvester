package com.graqr.threshr.model.redsky.store

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class GeographicSpecifications(
        val latitude: Double,
        val longitude: Double,
        @JsonProperty("time_zone_code") val timeZoneCode: String,
        @JsonProperty("time_zone_description") val timeZoneDescription: String,
        @JsonProperty("time_zone_utc_offset_name") val timeZoneUtcOffsetName: String,
        @JsonProperty("time_zone_offset_hours") val timeZoneOffsetHours: String,
        @JsonProperty("is_daylight_savings_time_recognized") val isDaylightSavingsTimeRecognized: Boolean,
        @JsonProperty("iso_time_zone_code") val isoTimeZoneCode: String) {
}
