package com.graqr.threshr.model.redsky.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class ProductDescription(
        @JsonProperty("bullet_descriptions") val bulletDescriptions: List<String>,
        @JsonProperty("downstream_description") val downstreamDescription: String,
        @JsonProperty("soft_bullet_description") val softBulletDescription: String,
        @JsonProperty("soft_bullets") val softBullets: SoftBullets, val title: String) {
}
