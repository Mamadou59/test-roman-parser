package org.msd;

import org.junit.Before;
import org.junit.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RomanParserTest {

    private RomanParser romanParser;

    @Before
    public void init(){
        this.romanParser = new RomanParser();
    }

    @Test
    public void parseShouldParseCorrectly() {
        assertEquals(159, romanParser.parse("CLIX"));
        assertEquals(14, romanParser.parse("XIV"));
        assertEquals(65, romanParser.parse("LXV"));
    }

    @Test
    public void parseShouldThrowNumberFormatExceptionWhenRomanCharacterIsNotReferenced(){
        assertThrows(NumberFormatException.class, () -> this.romanParser.parse("AXI"));
    }

    @Test(expected = NumberFormatException.class)
    public void parseShouldThrowNumberFormatExceptionWhenParsedNumberWithLengthGretherThanTreeGiveRomanBaseValue(){
        this.romanParser.parse("IVI");
    }

    @Test(expected = NumberFormatException.class)
    public void parseShouldThrowNumberFormatExceptionWhenParsedNumberWithLengthGretherThanTreeGiveRomanBaseValue2(){
        this.romanParser.parse("IXI");
    }

    @Test(expected = NumberFormatException.class)
    public void parseShouldThrowNumberFormatExceptionWhenParsedNumberIsVX(){
        this.romanParser.parse("VX");
    }
    @Test(expected = NumberFormatException.class)
    public void parseShouldThrowNumberFormatExceptionWhenParsedNumberIsLC(){
        this.romanParser.parse("LC");
    }
    @Test(expected = NumberFormatException.class)
    public void parseShouldThrowNumberFormatExceptionWhenParsedNumberIsDM(){
        this.romanParser.parse("DM");
    }
}