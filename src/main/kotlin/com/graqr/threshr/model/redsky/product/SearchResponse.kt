package com.graqr.threshr.model.redsky.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
data class SearchResponse(
        val metadata: Metadata,
        @JsonProperty("facet_list")
        val facets: List<Facet>,
        @JsonProperty("visual_facet_list")
        val visualFacets: List<Facet>
) {
}
