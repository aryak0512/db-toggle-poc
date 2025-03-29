package com.aryak.db.utils;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Demonstrates how to unit test a static method
 */
class CommonUtilsTest {

    @Test
    void prepareUrl() {

        String url = "http://localhost:8080/api/v1/{key}/{value}";
        var pathVariables = Map.of("{key}", "abc", "{value}", "86");
        var actual = CommonUtils.prepareUrl(url, pathVariables);
        assertThat(actual).isEqualTo("http://localhost:8080/api/v1/abc/86");
    }


    @Test
    public void t1(){



    }

    @Test
    void dumpToDatabase() {
    }

    @Test
    void process() {
        try (MockedStatic<CommonUtils> mockedStatic = Mockito.mockStatic(CommonUtils.class)) {
            // Mock the static method to return true
            mockedStatic.when(() -> CommonUtils.process(anyString())).thenReturn(true);

            // Ensure that the mock is actually being used
            boolean result = CommonUtils.process("576");

            // Verify that the static method was called
            mockedStatic.verify(() -> CommonUtils.process("576"), times(1));

            // Check if the return value is as expected
            assertTrue(result);
        }
    }
}