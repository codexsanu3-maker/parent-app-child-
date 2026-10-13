package org.familysafety.child

import org.junit.Assert.*
import org.junit.Test

class PairingFormatTest {
    @Test fun acceptsDemoFormat() {
        assertTrue("ABCDEFG2".matches(Regex("[23456789ABCDEFGHJKLMNPQRSTUVWXYZ]{6,12}")))
    }

    @Test fun rejectsAmbiguousCharacters() {
        assertFalse("O0IL1111".matches(Regex("[23456789ABCDEFGHJKLMNPQRSTUVWXYZ]{6,12}")))
    }

    @Test fun rejectsTooShort() {
        assertFalse("ABC".matches(Regex("[23456789ABCDEFGHJKLMNPQRSTUVWXYZ]{6,12}")))
    }
}
