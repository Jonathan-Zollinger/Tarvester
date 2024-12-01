package com.graqr.threshr.model.redsky.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable
import jakarta.annotation.Nullable

@Serdeable
data class Compliance(
        @Nullable @JsonProperty("is_proposition_65")
        val isProposition65: Boolean,
        @Nullable @JsonProperty("is_snap_eligible")
        val isSnapEligible: Boolean) {
}
