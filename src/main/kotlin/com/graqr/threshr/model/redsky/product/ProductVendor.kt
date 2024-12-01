package com.graqr.threshr.model.redsky.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class ProductVendor(val id: String, @JsonProperty("vendor_name") val vendorName: String) {
}
