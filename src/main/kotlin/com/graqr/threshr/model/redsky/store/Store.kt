package com.graqr.threshr.model.redsky.store

import com.fasterxml.jackson.annotation.JsonProperty
import io.micronaut.core.annotation.Introspected
import io.micronaut.core.annotation.Nullable
import io.micronaut.serde.annotation.Serdeable

@Serdeable
@Introspected
data class Store(
    val status: String,
    @JsonProperty("store_id") val storeId: String,
    @JsonProperty("location_name") val locationName: String,
    val distance: Double,
    @JsonProperty("main_voice_phone_number") val mainVoicePhoneNumber: String,
    @JsonProperty("mailing_address") val mailingAddress: MailingAddress,
    @JsonProperty("rolling_operating_hours") val rollingOperatingHours: RollingOperatingHours,
    @Nullable val geofence: Geofence,
    @Nullable val capabilities: List<Capability>,
    @Nullable @JsonProperty("drive_up") val driveUp: DriveUp,
    @Nullable @JsonProperty("contact_information") val contactInformation: List<ContactInformation>,
    @Nullable @JsonProperty("physical_specifications") val physicalSpecifications: PhysicalSpecifications,
    @Nullable @JsonProperty("geographic_specifications") val geographicSpecifications: GeographicSpecifications,
    @Nullable val miscellaneous: Miscellaneous
) {}
