package com.zte.ums.agile.homework.tdd3.guess_number;

import static org.junit.Assert.*;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
@RunWith(PowerMockRunner.class)  
@PrepareForTest(GuessNumber.class) 
public class GuessNumberSingleTest {

    @Test
    public void test_generate_bingoNumber_should_return_difference_number_when_generate_twice() {
        GuessNumber guessNumber = new GuessNumber();

        Class class1 = guessNumber.getClass();
        try {
            Method format = class1.getDeclaredMethod("generateBingoNumber");
            format.setAccessible(true);// 设为可见
            List<String> bingoNumber1 = (List) format.invoke(guessNumber);
            List<String> bingoNumber2 = (List) format.invoke(guessNumber);
            assertThat(Objects.equal(bingoNumber1, bingoNumber2), Matchers.is(false));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_generate_bingoNumber_should_return_same_result_when_guess_twice() {
        GuessNumber guessNumber = new GuessNumber();
        guessNumber.start();

        // 无法同时使用@RunWith Parameterized和PowerMockRunner，这里只有通过反射来修改成员变量以到达mock的目的
        Class clazz = guessNumber.getClass();  
        try {  
            Field countField = clazz.getDeclaredField("bingoNumberList");  
            countField.setAccessible(true);//设置该字段可见  
            List<String> bingoNumberList = Lists.newArrayList();
            bingoNumberList.add("6");
            bingoNumberList.add("7");
            bingoNumberList.add("8");
            bingoNumberList.add("9");
            countField.set(guessNumber, bingoNumberList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(guessNumber.guess("6789"), guessNumber.guess("6789"));
        assertThat(guessNumber.guess("6789"), Matchers.is("4A0B"));
    }

}