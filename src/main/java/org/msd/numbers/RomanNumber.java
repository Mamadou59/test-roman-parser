package org.msd.numbers;

import lombok.*;

/**
 * Pour cette proposition, on aurait pu le faire avec une conception plus générique utilisant des classes abstraites et
 * de l'heritage tout en essayant de reconstruire la chaine de manière recursive mais sachant que les chiffres romains sont connus d'office,
 * il n'y a pas besoin de mettre en place une solution respectant les principes de l'open close ou du SOLID.
 * Je trouve la solution ci-dessous plus simple
 */
@Getter
@Setter
public class RomanNumber {
    private static RomanNumber romanNumber = null;
    private String romanChar;
    private Integer convertedValue;

    private RomanNumber(String romanChar){
        this.romanChar = romanChar;
        this.convertedValue = RomanUtil.ROMAN_TO_NUMBER.get(romanChar);
    }

    public static RomanNumber romanCharToNumeric(String romanChar){
        if(!RomanUtil.ROMAN_TO_NUMBER.containsKey(romanChar)){
            throw new NumberFormatException("Character \"" + romanChar
                    + "\" is not roman symbol!");
        }
        if(romanNumber == null) {
            romanNumber = new RomanNumber(romanChar);
        } else {
            romanNumber.setConvertedValue(RomanUtil.ROMAN_TO_NUMBER.get(romanChar));
        }
        return romanNumber;
    }
}
