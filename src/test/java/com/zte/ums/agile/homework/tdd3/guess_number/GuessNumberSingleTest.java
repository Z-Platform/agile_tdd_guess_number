package com.zte.ums.agile.homework.tdd3.guess_number;

import static org.junit.Assert.*;

import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Test;

import com.google.common.base.Objects;

public class GuessNumberSingleTest {

    @Test
    public void test_generate_bingoNumber_should_return_difference_number_when_generate_twice() {
        GuessNumber guessNumber = new GuessNumber();
        List<String> bingoNumber1 = guessNumber.generateBingoNumber();
        List<String> bingoNumber2 = guessNumber.generateBingoNumber();
        
        assertThat(Objects.equal(bingoNumber1, bingoNumber2), Matchers.is(false));
    }

}