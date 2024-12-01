package com.graqr.threshr.model.redsky.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
data class NutritionFacts(
        val ingredients: String,
        @JsonProperty("nutrition_label_type_code") val nutritionLabelTypeCode: String,
        @JsonProperty("value_prepared_list") val valuePreparedList: List<ValuePreparedList>
) {
}
