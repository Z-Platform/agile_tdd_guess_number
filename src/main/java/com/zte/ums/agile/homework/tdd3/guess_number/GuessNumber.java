package com.zte.ums.agile.homework.tdd3.guess_number;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class GuessNumber {

    public String guess(String input) {
        List<String> bingoNumberList = Lists.newArrayList();
        bingoNumberList.add("6");
        bingoNumberList.add("7");
        bingoNumberList.add("8");
        bingoNumberList.add("9");
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
        return "0A" + (4 - inputSet.size()) + "B";
    }
}