package org.familysafety.parent.pairing

import org.junit.Assert.*
import org.junit.Test

class PairingCodeTest {
    @Test fun generatedCodeHasExpectedLength() {
        assertEquals(8, PairingCode.generate().length)
    }

    @Test fun generatedCodeUsesUnambiguousAlphabet() {
        val code = PairingCode.generate()
        assertTrue(code.all { it in "23456789ABCDEFGHJKLMNPQRSTUVWXYZ" })
    }

    @Test(expected = IllegalArgumentException::class)
    fun rejectsInvalidLength() {
        PairingCode.generate(3)
    }
}
