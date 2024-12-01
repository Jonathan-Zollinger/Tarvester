package com.graqr.threshr.model.redsky.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Nullable
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Fulfillment(
        @Nullable @JsonProperty("is_gift_wrap_eligible")
        val isGiftWrapEligible: Boolean,
        @Nullable @JsonProperty("purchase_limit")
        val purchaseLimit: Long,
        @Nullable @JsonProperty("product_id")
        val productId: String,
        @Nullable @JsonProperty("is_out_of_stock_in_all_store_locations")
        val isOutOfStockInAllStoreLocations: Boolean,
        @Nullable @JsonProperty("sold_out")
        val soldOut: Boolean,
        @Nullable @JsonProperty("shipping_options")
        val shippingOptions: ShippingOptions,
        @Nullable @JsonProperty("store_options")
        val storeOptions: List<StoreOption>,
        @Nullable @JsonProperty("scheduled_delivery")
        val scheduledDeliver: ScheduledDelivery) {
}
