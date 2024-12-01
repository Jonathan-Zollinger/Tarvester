package com.graqr.threshr.model.redsky.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
data class FindsStory(
        val id: String,
        @JsonProperty("channel_id")
        val channelId: String,
        val description: String,
        @JsonProperty("display_date")
        val displayDate: String,
        @JsonProperty("highlight_color")
        val highlightColor: String,
        val image: Image,
        val images: List<Image>,
        val label: String,
        val name: String,
        @JsonProperty("short_title")
        val shortTitle: String,
        val title: String,
        val url: String) {
}
