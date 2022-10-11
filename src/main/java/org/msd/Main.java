package org.msd;

public class Main {
    public static void main(String[] args) {
        RomanParser romanParser = new RomanParser();
        System.out.println("CLIX => " + romanParser.parse("CLIX"));
        System.out.println("XIV => " + romanParser.parse("XIV"));
        System.out.println("XVI => " + romanParser.parse("XVI"));
        System.out.println("XIX => " + romanParser.parse("XIX"));
        System.out.println("XXIX => " + romanParser.parse("XXIX"));
        System.out.println("LXV => " + romanParser.parse("LXV"));
        System.out.println("V => " + romanParser.parse("V"));

        // INVALID ROMANS NUMBER FOR TEST
        //System.out.println("IXI => " + romanParser.parse("IXI"));
        //System.out.println("IVI => " + romanParser.parse("IVI"));
        //System.out.println("VX => " + romanParser.parse("VX"));
        //System.out.println("LC => " + romanParser.parse("LC"));
        //System.out.println("DM => " + romanParser.parse("DM"));
    }
}