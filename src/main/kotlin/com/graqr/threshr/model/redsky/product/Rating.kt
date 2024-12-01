package com.graqr.threshr.model.redsky.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Nullable
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Rating(
        @Nullable
        val average: Double,
        @Nullable
        val count: Long,
        @Nullable
        val distribution: Distribution,
        @JsonProperty("secondary_averages")
        @Nullable
        val secondaryAverages: List<SecondaryAverage>,
        @Nullable
        val value: Double,
        @JsonProperty("submitted_at")
        val submittedAt: String) {
}
