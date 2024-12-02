package com.graqr.threshr

import java.security.SecureRandom
import java.util.Base64

internal object Utils {
    /**
     * Generates a secure random string of the specified length.
     *
     * @param  length  the length of the random string to generate
     * @return         the generated random string
     */
    fun getSecureRandomString(length: Int): String {
        val random: SecureRandom = SecureRandom() // Compliant for security-sensitive use cases
        val bytes = ByteArray(length)
        random.nextBytes(bytes)
        val encoder: Base64.Encoder = Base64.getUrlEncoder().withoutPadding()
        return encoder.encodeToString(bytes)
    }
}