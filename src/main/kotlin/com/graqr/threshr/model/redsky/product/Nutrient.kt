package com.graqr.threshr.model.redsky.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Nutrient(
    val name: String,
    val quantity: Double,
    @JsonProperty("unit_of_measurement")
    val unitOfMeasurement: String,
    val percentage: Double
) {}
