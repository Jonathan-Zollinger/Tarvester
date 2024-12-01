package com.graqr.threshr.model.redsky.store;

import io.micronaut.serde.annotation.Serdeable;

@Serdeable
data class Geofence(val latitude: Double, val longitude: Double, val radius: Long) {}
