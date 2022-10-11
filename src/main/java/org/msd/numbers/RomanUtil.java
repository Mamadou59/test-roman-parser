package org.msd.numbers;

import java.util.HashMap;
import java.util.Map;

public class RomanUtil {
    public static final Map<String, Integer> ROMAN_TO_NUMBER = new HashMap<>();
    // Comme ces valeurs ne changerons jamais mieux vaut les avoirs en static et les définir sois même
    static {
        ROMAN_TO_NUMBER.put("I",1);
        ROMAN_TO_NUMBER.put("V",5);
        ROMAN_TO_NUMBER.put("X",10);
        ROMAN_TO_NUMBER.put("L",50);
        ROMAN_TO_NUMBER.put("C",100);
        ROMAN_TO_NUMBER.put("D",500);
        ROMAN_TO_NUMBER.put("M",1000);
    }
}
