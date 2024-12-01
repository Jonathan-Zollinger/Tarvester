package com.graqr.threshr.model.redsky.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
data class Statistics(
        @JsonProperty("not_recommended_count") val notRecommendedCount: Long,
        @JsonProperty("question_count") val questionCount: Long,
        val rating: Rating,
        @JsonProperty("recommended_count") val recommendedCount: Long,
        @JsonProperty("recommended_percentage") val recommendedPercentage: Long,
        @JsonProperty("review_count") val reviewCount: Long ) {
}
