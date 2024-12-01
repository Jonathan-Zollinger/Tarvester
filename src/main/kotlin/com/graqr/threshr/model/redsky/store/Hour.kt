package com.graqr.threshr.model.redsky.store

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Nullable
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Hour(
        @Nullable @JsonProperty("begin_date")
        val beginDate: String,
        @JsonProperty("begin_time") val beginTime: String,
        @JsonProperty("end_date") val endDate: String,
        @JsonProperty("end_time") val endTime: String) {
}
