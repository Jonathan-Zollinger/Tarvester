package com.graqr.threshr.model.redsky.store

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class NearbyStores(val count: Long, val stores: List<Store>) {}
