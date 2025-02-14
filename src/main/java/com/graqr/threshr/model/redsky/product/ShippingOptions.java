package com.graqr.threshr.model.redsky.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.micronaut.serde.annotation.Serdeable;

import java.util.List;

@Serdeable
public record ShippingOptions(
        @JsonProperty("availability_status")
        String availabilityStatus,
        @JsonProperty("loyalty_availability_status")
        String loyaltyAvailabilityStatus,
        List<?> services) {
}
