package com.graqr.threshr.model.redsky.store

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class CapabilityHour(@JsonProperty("capability_code") val capabilityCode: String, val days: List<Day>) {}
