package com.graqr.threshr.model.redsky.store

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Capability(@JsonProperty("capability_code") val capabilityCode: String,
                         @JsonProperty("capability_name") val capabilityName: String,
                         @JsonProperty("effective_date") val effectiveDate: String) {}
