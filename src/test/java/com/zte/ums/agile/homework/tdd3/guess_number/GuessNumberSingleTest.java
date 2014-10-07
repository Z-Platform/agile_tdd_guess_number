package com.zte.ums.agile.homework.tdd3.guess_number;

import static org.junit.Assert.*;

import java.lang.reflect.Method;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.google.common.base.Objects;
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

}