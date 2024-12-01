package com.graqr.threshr.model.redsky.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
data class ReturnPolicy(@JsonProperty("user_type") val userType: String, @JsonProperty("day_count") val dayCount: Long) {}
