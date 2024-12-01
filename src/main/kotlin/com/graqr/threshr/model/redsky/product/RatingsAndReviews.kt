package com.graqr.threshr.model.redsky.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
data class RatingsAndReviews(
        @JsonProperty("has_verified")
        val hasVerified: Boolean,
        val statistics: Statistics,
        @JsonProperty("most_recent")
        val mostRecent: List<MostRecent>,
        val photos: List<String>
) {
}
