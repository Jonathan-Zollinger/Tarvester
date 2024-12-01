package com.graqr.threshr.model.redsky.product

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Nullable
import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class Item(
        @Nullable @JsonProperty("cart_add_on_threshold")
        val cartAddOnThreshold: Double,
        val compliance: Compliance,
        @Nullable
        val disclaimer: Disclaimer,
        val dpci: String,
        @JsonProperty("eligibility_rules")
        val eligibilityRules: EligibilityRules,
        val enrichment: Enrichment,
        @Nullable @JsonProperty("environmental_segmentation")
        val environmentalSegmentation: EnvironmentalSegmentation,
        @Nullable @JsonProperty("formatted_return_method")
        val formattedReturnMethod: String,
        val fulfillment: Fulfillment,
        @Nullable
        val handling: Handling,
        @Nullable @JsonProperty("is_fresh_grocery")
        val isFreshGrocery: Boolean,
        @JsonProperty("is_limited_time_offer")
        val isLimitedTimeOffer: Boolean,
        @JsonProperty("merchandise_classification")
        val merchandiseClassification: MerchandiseClassification,
        @Nullable @JsonProperty("package_dimensions")
        val packageDimensions: PackageDimensions,
        @Nullable @JsonProperty("primary_barcode")
        val primaryBarcode: String,
        @JsonProperty("primary_brand")
        val primaryBrand: PrimaryBrand,
        @JsonProperty("product_classification")
        val productClassification: PrimaryBrand,
        @JsonProperty("product_description")
        val productDescription: ProductDescription,
        @JsonProperty("product_vendors")
        val productVendors: List<ProductVendor>,
        @JsonProperty("relationship_type_code")
        val relationshipTypeCode: String,
        @Nullable @JsonProperty("return_policies_guest_message")
        val returnPoliciesGuestMessage: String,
        @Nullable
        val ribbons: List<String>,
        @Nullable @JsonProperty("wellness_merchandise_attributes")
        val wellnessMerchandiseAttributes: List<Any>
) {
}
