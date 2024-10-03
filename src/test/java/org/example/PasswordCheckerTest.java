package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class PasswordCheckerTest {
    static PasswordChecker checker = new PasswordChecker();

    @ParameterizedTest
    @CsvSource (
            value = {
                    "Password, true",
                    "Hugoo, true",
                    "Geneeric, true",
                            "Booosty, false",
                            "Brig, false",
                            "null, false",
            })
    void verifyPositive(String password, boolean expected){
        checker.setMinLength(5);
        checker.setMaxRepeats(2);
        Assertions.assertEquals(expected, checker.verify(password));
    }


    @Test
    void testExceptionSetMinLength() {
        //given
        int len1 = -1;
       assertThrows(IllegalStateException.class,()->{
           checker.setMinLength(len1);
       });
    }


    @Test
    void setMaxRepeats() {
        int reps=2;
        checker.setMaxRepeats(reps);
        assertEquals(reps,checker.getMaxRepeats());
    }

}