package com.adam.testingcardlogic

import org.junit.Assert.*
import org.junit.Test

class CardValidationTest {

    val cardValidation = CardValidation()

    @Test
    fun `Check the card for its valid state`() { //only available unit test
        val sampleCard = "3796-1231-3426-0624"  // AMEX
        val sampleCard2 = "1111-1231-3426-0624" // ALFA
        val sampleExpiryDate = "06/24"

        val result = cardValidation.validate(sampleCard, sampleExpiryDate)
        val result2 = cardValidation.validate(sampleCard2, sampleExpiryDate)

        assertTrue(result)
        assertTrue(result2)
    }

    @Test
    fun `Check the card for its invalid state`() { //only available unit test
        val sampleCard = "1234-1231-3426-0321"
        val sampleCard2 = "1234--3426-0321"
        val sampleCard3 = "1234dd-3426-0321"
       val sampleCard4 = "1234-0321"
        val sampleExpiryDate = "06/24"

        val result = cardValidation.validate(sampleCard, sampleExpiryDate)
        val result2 = cardValidation.validate(sampleCard2, sampleExpiryDate)
        val result3 = cardValidation.validate(sampleCard3, sampleExpiryDate)
        val result4 = cardValidation.validate(sampleCard4, sampleExpiryDate)

        assertFalse(result)
        assertTrue(result2)
        assertFalse(result3)
        assertFalse(result4)
    }

    @Test
    fun `verify the date is valid within a CARD`() {
        val sampleCard = "1234-1231-3426-0624"
        val sampleExpiryDate = "06/24"

        assertTrue(cardValidation.validateDate(sampleExpiryDate, sampleCard))
    }

    @Test
    fun `verify the date is invalid within a CARD`() {
        val sampleCard = "1234-1231-3426-0224"
        val sampleExpiryDate = "06/24"
        val sampleExpiryDate2 = "02/24"
        val sampleExpiryDate3 = "0/4"
        val sampleExpiryDate4 = "13/19"
        val sampleExpiryDate5 = "06/18"

        assertFalse(cardValidation.validateDate(sampleExpiryDate, sampleCard))
        assertTrue(cardValidation.validateDate(sampleExpiryDate2, sampleCard))
        assertFalse(cardValidation.validateDate(sampleExpiryDate3, sampleCard))
        assertFalse(cardValidation.validateDate(sampleExpiryDate4, sampleCard))
        assertFalse(cardValidation.validateDate(sampleExpiryDate5, sampleCard))
    }


}