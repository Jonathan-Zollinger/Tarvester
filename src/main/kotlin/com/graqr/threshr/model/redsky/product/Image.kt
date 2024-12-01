package com.graqr.threshr.model.redsky.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
data class Image(
        val url: String,
        @JsonProperty("alt_text")
        val altText: String,
        val height: Long,
        val width: Long,
        @JsonProperty("aspect_ratio")
        val aspectRatio: String){
}