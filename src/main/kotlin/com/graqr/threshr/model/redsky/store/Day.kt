package com.graqr.threshr.model.redsky.store

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Nullable
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Day(
        @JsonProperty("is_open") val isOpen: Boolean,
        val date: String,
        @JsonProperty("day_name")
        val dayName: String,
        val hours: List<Hour>,
        @Nullable @JsonProperty("sequence_number")
        val sequenceNumber: String) {
}