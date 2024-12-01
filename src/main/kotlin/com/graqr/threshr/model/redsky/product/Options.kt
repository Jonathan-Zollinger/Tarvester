package com.graqr.threshr.model.redsky.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
data class Options(
        @JsonProperty("display_name")
        val displayName: String,
        @JsonProperty("canonical_name")
        val canonicalName: String,
        val id: String,
        @Nullable val source: String,
        @JsonProperty("image_url")
        @Nullable val imageUrl: String,
        val url: String,
        val value: String
) {
}
