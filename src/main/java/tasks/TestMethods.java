package tasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TestMethods {


    @Test
    public void testReversedUsersWithPalindromes() {
        String input = "[{\"id\":1,\"firstname\":\"Anna\",\"lastname\":\"Graham\",\"username\":\"angr\",\"age\":30},{\"id\":2,\"firstname\":\"Ervin\",\"lastname\":\"Howell\",\"username\":\"erho\",\"age\":24}]";
        String expectedOutput = "[{\"id\":1,\"firstname\":\"annA *Palindrom*\",\"lastname\":\"Graham\",\"username\":\"angr\",\"age\":30},{\"id\":2,\"firstname\":\"nivrE\",\"lastname\":\"Howell\",\"username\":\"erho\",\"age\":24}]";
        String actualOutput = Methods.reversedUsers(input);
        Assertions.assertEquals(expectedOutput, actualOutput);
    }


    // Test för: Skriv en metod som kan hitta det n-te största talet i en lista av
    // tal
    @Test
    public void testFindLargestNumber() {
        // testar vanlig use case
        List<Integer> numbers = Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3);
        int largestNumber = Methods.findLargestNumber(numbers);
        Assertions.assertEquals(9, largestNumber);

        // testar lista med ett objekt
        numbers = Collections.singletonList(42);
        largestNumber = Methods.findLargestNumber(numbers);
        Assertions.assertEquals(42, largestNumber);

        // testar negativa tal
        numbers = Arrays.asList(-1, -2, -3, -4, -5);
        largestNumber = Methods.findLargestNumber(numbers);
        Assertions.assertEquals(-1, largestNumber);
    }

    @Test
    // testar tom lista
    public void testEmptyList() {
        List<Integer> emptyList = Collections.emptyList();
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> FindLargestNumber.findLargestNumber(emptyList));
    }

    // test för: Skriv en metod som lägger till nollor framför tal, 1 ska bli "00001"
    // och 100 ska bli "00100" 
    @Test
    //testar vanlig use case
    public void testPositiveNumber() {
        int n = 1234;
        String expected = "01234";
        String actual = Methods.formatedNumbers(n);
        assertEquals(expected, actual);
    }

    @Test
    //testar negativt tal
    public void testNegativeNumber() {
        int n = -567;
        String expected = "-00567";
        String actual = Methods.formatedNumbers(n);
        assertEquals(expected, actual);
    }

    @Test
    //testar 0
    public void testZero() {
        int n = 0;
        String expected = "00000";
        String actual = Methods.formatedNumbers(n);
        assertEquals(expected, actual);
    }

    @Test
    //testar max integer value
    public void testMaxValue() {
        int n = Integer.MAX_VALUE;
        String expected = "2147483647";
        String actual = Methods.formatedNumbers(n);
        assertEquals(expected, actual);
    }

    @Test
    //testar min integer value
    public void testMinValue() {
        int n = Integer.MIN_VALUE;
        String expected = "-2147483648";
        String actual = Methods.formatedNumbers(n);
        assertEquals(expected, actual);
    }
}