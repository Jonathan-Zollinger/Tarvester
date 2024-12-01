package com.graqr.threshr.model.redsky.product.summary

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class ProductSummaryRoot(val data: Data) {
}
