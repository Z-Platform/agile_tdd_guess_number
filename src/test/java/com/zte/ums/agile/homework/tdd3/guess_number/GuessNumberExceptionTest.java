package com.zte.ums.agile.homework.tdd3.guess_number;

import static org.junit.Assert.*;

import java.util.IllegalFormatException;

import org.junit.Before;
import org.junit.Test;

public class GuessNumberExceptionTest {
    private GuessNumber guessNumber;

    @Before
    public void setUp() {
        this.guessNumber =  new GuessNumber();
    }

    @Test(expected = IllegalFormatException.class)
    public void test_guess_should_throws_IllegalFormatException() {
        this.guessNumber.guess("1123");
    }

}
