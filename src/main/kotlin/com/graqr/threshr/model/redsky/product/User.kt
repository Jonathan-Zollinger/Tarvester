package com.graqr.threshr.model.redsky.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
data class User(
        @JsonProperty("display_name")
        val displayName: String,
        @JsonProperty("image_alt_text")
        val imageAltText: String,
        @JsonProperty("image_url")
        val imageUrl: String,
        val url: String,
        val username: String) {
}

