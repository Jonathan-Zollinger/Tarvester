package com.graqr.threshr.model.redsky.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;
import jakarta.annotation.Nullable;

@Serdeable
data class Video(
        @JsonProperty("video_files") val videoFiles: List<VideoFile>,
        @Nullable @JsonProperty("video_captions") val videoCaptions: List<VideoCaption>,
        @Nullable @JsonProperty("video_length_seconds") val videoLengthSeconds: String,
        @Nullable @JsonProperty("video_poster_image") val videoPosterImage: String,
        @Nullable @JsonProperty("video_title") val videoTitle: String,
        @Nullable val isListPageEligible: Boolean) {
}
