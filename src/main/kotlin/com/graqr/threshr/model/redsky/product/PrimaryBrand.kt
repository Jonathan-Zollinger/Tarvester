package com.graqr.threshr.model.redsky.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class PrimaryBrand(
        @JsonProperty("canonical_url")
        val canonicalUrl: String,
        @JsonProperty("linking_id")
        val linkingId: String,
        val name: String) {
}
