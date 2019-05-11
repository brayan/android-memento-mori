package br.com.sailboat.mementomori.domain.helper

import org.junit.Assert
import org.junit.Test
import java.math.BigDecimal

class DecimalHelperTest {

    @Test
    fun testRound() {
        Assert.assertEquals(BigDecimal.valueOf(1.56), DecimalHelper.round(1.556, 2))
        Assert.assertEquals(BigDecimal.valueOf(255.27), DecimalHelper.round(255.274999999, 2))
    }

    @Test
    fun testToPresentation() {
        Assert.assertEquals("1.556", DecimalHelper.toPresentation(1.556))
        Assert.assertEquals("255.274999999", DecimalHelper.toPresentation(255.274999999))
        Assert.assertEquals("255", DecimalHelper.toPresentation(255.0000))
    }

}