package com.graqr.threshr.model.redsky.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
data class EnvironmentalSegmentation(
        @JsonProperty("is_hazardous_material")
        val isHazardousMaterial: Boolean) {
}
