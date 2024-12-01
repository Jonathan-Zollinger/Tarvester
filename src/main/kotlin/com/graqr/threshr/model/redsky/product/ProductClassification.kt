package com.graqr.threshr.model.redsky.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.core.annotation.Nullable;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
data class ProductClassification(
        @Nullable @JsonProperty("product_type") val productType: Long,
        @Nullable @JsonProperty("product_type_name") val productTypeName: String,
        @Nullable @JsonProperty("purchase_behavior") val purchaseBehavior: String,
        @Nullable @JsonProperty("item_type") val itemType: ItemType) {
}
