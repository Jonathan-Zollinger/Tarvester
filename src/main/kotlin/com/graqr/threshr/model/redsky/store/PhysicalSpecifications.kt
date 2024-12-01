package com.graqr.threshr.model.redsky.store

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class PhysicalSpecifications(
    @JsonProperty("total_building_area") val totalBuildingArea: Long,
    @JsonProperty("merchandise_level") val merchandiseLevel: Long,
    val format: String
) {}
