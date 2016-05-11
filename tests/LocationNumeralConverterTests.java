/**
 * LocationNumeralConverterTests.java
 *
 * Series of JUnit Tests for the LocationNumeralConverter class
 * Created by Edison Jimenez on 5/10/16.
 */

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LocationNumeralConverterTests {

    private LocationNumeralConverter locationNumeralConverter;

    @Before
    public void setUp() {
        locationNumeralConverter = new LocationNumeralConverter();
    }




    /* Decimal to Abbreviated Location Numeral Tests */

    @Test
    public void emptyLocationNumeralTest() {
        assertEquals("", locationNumeralConverter.toLocationNumeral(0));
    }

    @Test
    public void negativeLocationNumeralTest() {
        assertEquals("", locationNumeralConverter.toLocationNumeral(-3));
    }

    @Test
    public void toLocationNumeralTest() {
        assertEquals("abceg", locationNumeralConverter.toLocationNumeral(87));
    }

    @Test
    public void toLocationNumeralTest2() {
        assertEquals("abdgkl", locationNumeralConverter.toLocationNumeral(3147));
    }

    @Test
    public void toLocationNumeralTest3() {
        assertEquals("ad", locationNumeralConverter.toLocationNumeral(9));
    }

    @Test
    public void toLocationNumeralTest4() {
        assertEquals("acdeh", locationNumeralConverter.toLocationNumeral(157));
    }

    @Test
    public void toLocationNumeralTest5() {
        assertEquals("bcfgh", locationNumeralConverter.toLocationNumeral(230));
    }

    @Test
    public void toLocationNumeralTest6() {
        assertEquals("bcekl", locationNumeralConverter.toLocationNumeral(3094));
    }





    /* Location Numeral to Decimal Tests */
    @Test
    public void emptyStringDecimalTest() {
        assertEquals(0, locationNumeralConverter.toDecimal(""));
    }

    @Test
    public void nullStringDecimalTest () {
        assertEquals(0, locationNumeralConverter.toDecimal(null));
    }

    @Test
    public void whitespaceStringDecimalTest () {
        assertEquals(0, locationNumeralConverter.toDecimal(" "));
    }

    @Test
    public void toDecimalTest() {
        assertEquals(87, locationNumeralConverter.toDecimal("abceg"));
    }

    @Test
    public void toDecimalTest2() {
        assertEquals(3147, locationNumeralConverter.toDecimal("abdgkl"));
    }

    @Test
    public void toDecimalTest3() {
        assertEquals(9, locationNumeralConverter.toDecimal("ad"));
    }

    @Test
    public void toDecimalTest4() {
        assertEquals(157, locationNumeralConverter.toDecimal("acdeh"));
    }

    @Test
    public void toDecimalTest5() {
        assertEquals(230, locationNumeralConverter.toDecimal("bcfgh"));
    }

    @Test
    public void toDecimalTest6() {
        assertEquals(3094, locationNumeralConverter.toDecimal("bcekl"));
    }





    /* Extended Location Numeral to Abbreviated Location Numeral Tests */

    @Test
    public void emptyAbbreviatedLocationNumeralTest() {
        assertEquals("", locationNumeralConverter.toAbbreviatedNumeral(""));
    }

    @Test
    public void nullAbbreviatedLocationNumeralTest() {
        assertEquals("", locationNumeralConverter.toAbbreviatedNumeral(null));
    }

    @Test
    public void whitespaceAbbreviatedLocationNumeralTest() {
        assertEquals("", locationNumeralConverter.toAbbreviatedNumeral(" "));
    }

    @Test
    public void toAbbreviatedLocationNumeralTest() {
        assertEquals("ad", locationNumeralConverter.toAbbreviatedNumeral("abbc"));
    }

    @Test
    public void toAbbreviatedLocationNumeralTest2() {
        assertEquals("ace", locationNumeralConverter.toAbbreviatedNumeral("acccd"));
    }

    @Test
    public void toAbbreviatedLocationNumeralTest3() {
        assertEquals("abhi", locationNumeralConverter.toAbbreviatedNumeral("abccdefghh"));
    }

    @Test
    public void toAbbreviatedLocationNumeralTest4() {
        assertEquals("bcejm", locationNumeralConverter.toAbbreviatedNumeral("bcddeefffgghhiijkl"));
    }

}
