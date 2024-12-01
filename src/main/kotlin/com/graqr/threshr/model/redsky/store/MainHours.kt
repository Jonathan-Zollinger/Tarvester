package com.graqr.threshr.model.redsky.store

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class MainHours(val days: List<Day>) {}
