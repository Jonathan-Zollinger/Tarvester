package com.graqr.threshr.model.redsky.store;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
public record GeographicSpecifications(
        Double latitude,
        Double longitude,
        @JsonProperty("time_zone_code") String timeZoneCode,
        @JsonProperty("time_zone_description") String timeZoneDescription,
        @JsonProperty("time_zone_utc_offset_name") String timeZoneUtcOffsetName,
        @JsonProperty("time_zone_offset_hours") String timeZoneOffsetHours,
        @JsonProperty("is_daylight_savings_time_recognized") Boolean isDaylightSavingsTimeRecognized,
        @JsonProperty("iso_time_zone_code") String isoTimeZoneCode) {
}
