package com.graqr.threshr.model.redsky.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Nullable
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Search(
        @JsonProperty("search_recommendations")
        val searchRecommendations: SearchRecommendations,
        @JsonProperty("search_response")
        val searchResponse: SearchResponse,
        @Nullable
        @JsonProperty("search_suggestions")
        val searchSuggestions: List<String>,
        @Nullable
        val products: List<Product>
) {
}
