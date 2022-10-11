package org.msd;


import org.msd.numbers.RomanNumber;
import org.msd.numbers.RomanUtil;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

public class RomanParser {
    public Integer parse(String romanValue){
        Integer value = 0;
        RomanNumber parsedValue;
        List<String> romanValueToList = Arrays.asList(romanValue.trim().toUpperCase().split(""));
        ListIterator<String> iter = romanValueToList.listIterator(romanValueToList.size());
        int previousValue = 0;
        int sameValueRepeatTimes = 0;
        while(iter.hasPrevious()){
            String c = iter.previous();
            parsedValue = RomanNumber.romanCharToNumeric(c);
            this.checkValidity(c, previousValue);
            if(previousValue == parsedValue.getConvertedValue()){
                sameValueRepeatTimes += 1;
                if(sameValueRepeatTimes >= 3) {
                    throw new NumberFormatException("Character \"" + parsedValue.getRomanChar()
                            + "\" is repeated more than thrice!");
                }
                value += parsedValue.getConvertedValue();
            }
            else {
                sameValueRepeatTimes = 0;
                if(value <= parsedValue.getConvertedValue())
                    value += parsedValue.getConvertedValue();
                else{
                   value -= parsedValue.getConvertedValue();
                }
            }
            previousValue = parsedValue.getConvertedValue();

            /*Pas valide pour tous les cas la condition n'est pas complète.
            j'ai voulu éviter de le faire à la fin du parseur sachant qu'on peut savoir si la
            chaine est valide ou pas après quelques parcours.*/
            if((iter.hasNext() && iter.nextIndex()+1 != romanValueToList.size()) && RomanUtil.ROMAN_TO_NUMBER.containsValue(value)) {
                throw new NumberFormatException("Invalid roman number");
            }
        }
        return value;
    }

    private void checkValidity(String c, int previousValue){
        if((c.equals("V") && previousValue == 10) || (c.equals("L") && previousValue == 100)
                || (c.equals("D") && previousValue == 1000)){
            throw new NumberFormatException("Invalid roman number");
        }
    }
}
