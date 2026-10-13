package org.familysafety.parent.pairing

import java.security.SecureRandom

/** Demo-only code generator. Production codes must be server-issued, expiring and rate-limited. */
object PairingCode {
    private const val ALPHABET = "23456789ABCDEFGHJKLMNPQRSTUVWXYZ"
    private val random = SecureRandom()

    fun generate(length: Int = 8): String {
        require(length in 6..12) { "Code length must be 6..12" }
        return buildString(length) {
            repeat(length) { append(ALPHABET[random.nextInt(ALPHABET.length)]) }
        }
    }
}
