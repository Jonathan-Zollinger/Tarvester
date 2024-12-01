package com.graqr.threshr.model.redsky.store

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Nullable
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class MailingAddress(
        @JsonProperty("address_line1")
        val addressLine1: String,
        val city: String,
        @JsonProperty("country_code")
        val countryCode: String,
        val region: String,
        val state: String,
        @JsonProperty("postal_code")
        val postalCode: String,
        @Nullable val country: String) {
}
