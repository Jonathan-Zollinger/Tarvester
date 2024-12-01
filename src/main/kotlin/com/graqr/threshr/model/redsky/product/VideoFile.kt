package com.graqr.threshr.model.redsky.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class VideoFile(
        @JsonProperty("mime_type") val mimeType: String,
        @JsonProperty("video_height_pixels") val videoHeightPixels: String,
        @JsonProperty("video_url") val videoUrl: String) {
}
