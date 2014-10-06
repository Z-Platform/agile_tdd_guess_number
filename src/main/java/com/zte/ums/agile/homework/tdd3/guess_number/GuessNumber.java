package com.zte.ums.agile.homework.tdd3.guess_number;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UnknownFormatConversionException;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class GuessNumber {

    public String guess(String input) {

        Set<String> inputSet = Sets.newHashSet();
        for (int i = 0; i < input.length(); i++) {
            inputSet.add(String.valueOf(input.charAt(i)));
        }
        if (inputSet.size() != 4) {
            throw new UnknownFormatConversionException(input);
        }

        List<String> bingoNumberList = start();
        int countB = countB(input, bingoNumberList);
        int countA = countA(input, bingoNumberList);
        return printResult(countB, countA);
    }

    private int countB(String input, List<String> bingoNumberList) {
        Set<String> inputSet = Sets.newHashSet();
        for (int i = 0; i < input.length(); i++) {
            inputSet.add(String.valueOf(input.charAt(i)));
        }
        for (Iterator<String> iterator = inputSet.iterator(); iterator.hasNext();) {
            String intputOne = iterator.next();
            if (bingoNumberList.contains(intputOne)) {
                iterator.remove();
            }
        }
        int BCount = 4 - inputSet.size();
        return BCount;
    }
    
    private int countA(String input, List<String> bingoNumberList) {
        int countA = 0;
        for (int i = 0; i < bingoNumberList.size(); i++) {
            String bingoOne = bingoNumberList.get(i);
            String inputOnt = String.valueOf(input.charAt(i));
            if (inputOnt.equals(bingoOne)) {
                countA++;
            }
        }
        return countA;
    }

    private String printResult(int countB, int countA) {
        return countA+ "A" + (countB-countA) + "B";
    }

    private List<String> start() {
        List<String> bingoNumberList = Lists.newArrayList();
        bingoNumberList.add("6");
        bingoNumberList.add("7");
        bingoNumberList.add("8");
        bingoNumberList.add("9");
        return bingoNumberList;
    }
}