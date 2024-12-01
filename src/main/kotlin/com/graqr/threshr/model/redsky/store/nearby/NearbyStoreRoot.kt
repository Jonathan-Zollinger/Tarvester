package com.graqr.threshr.model.redsky.store.nearby

import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable

@Serdeable
@Introspected
data class NearbyStoreRoot(val data: Data) {
}

