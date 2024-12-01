package com.graqr.threshr.model.queryparam

import io.micronaut.core.annotation.Introspected
import java.util.stream.Collectors



/**
 * The `Tcin` class represents a Target Catalog Item Number (TCIN), which is a unique identifier for products
 * in the Target inventory system. Each TCIN is an 8-digit number that identifies a specific product.
 *
 * This class encapsulates a list of TCINs and ensures that all provided TCINs are valid 8-digit numbers.
 * It provides a method to retrieve the TCINs as a single comma-separated string.
 *
 * @property tcin A list of TCINs, each represented as an 8-digit number.
 * @throws IllegalArgumentException if any TCIN in the list is not a valid 8-digit number.
 * @author Jonathan Zollinger
 * @since 0.1.0
 */
@Introspected
data class Tcin(val tcin: List<String>) {
    init {
        require(tcin.stream().allMatch(Regex("\\d{8}")::matches)) {
            "Invalid tcin provided, \"" + tcin.stream().collect(
                Collectors.partitioningBy(Regex("\\d{8}")::matches, Collectors.joining(", "))
            ) + "\". Tcin must be a 8-digit number."
        }
    }

    /**
     * Returns a single string of comma-separated TCINs, rather than a list of strings,
     * so that it can be used with Micronaut's deserialization mechanism when retrieving data from the RedSky API.
     */
    fun getTcins(): String {
        return tcin.stream().collect(Collectors.joining(","))
    }
}