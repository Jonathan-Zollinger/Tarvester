package com.graqr.threshr.model.redsky.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

@Serdeable
data class MerchandiseClassification(
        @JsonProperty("class_id") val classId: Long,
        @JsonProperty("department_id") val departmentId: Long,
        @JsonProperty("department_name") val departmentName: String) {
}
