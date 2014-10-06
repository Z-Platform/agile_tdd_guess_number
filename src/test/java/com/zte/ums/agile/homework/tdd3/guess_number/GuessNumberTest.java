package com.zte.ums.agile.homework.tdd3.guess_number;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class GuessNumberTest {

    @Test
    public void test_should_return_0A0B_when_0A0B() {
        GuessNumber guessNumber =  new GuessNumber();
        String result = guessNumber.guess("1234");

        assertThat(result, is("0A0B"));
    }

    @Test
    public void test_should_return_0A1B_when_0A1B() {
        GuessNumber guessNumber =  new GuessNumber();
        String result = guessNumber.guess("9234");

        assertThat(result, is("0A1B"));
    }

    @Test
    public void test_should_return_0A2B_when_0A2B() {
        GuessNumber guessNumber =  new GuessNumber();
        String result = guessNumber.guess("9834");

        assertThat(result, is("0A2B"));
    }

    @Test
    public void test_should_return_0A3B_when_0A3B() {
        GuessNumber guessNumber =  new GuessNumber();
        String result = guessNumber.guess("9874");

        assertThat(result, is("0A3B"));
    }

    @Test
    public void test_should_return_0A4B_when_0A4B() {
        GuessNumber guessNumber =  new GuessNumber();
        String result = guessNumber.guess("9876");

        assertThat(result, is("0A4B"));
    }

}