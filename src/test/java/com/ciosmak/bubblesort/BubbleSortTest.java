package com.ciosmak.bubblesort;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;


class BubbleSortTest
{
    private List<Comparable> sortedNumbers;

    @ParameterizedTest
    @MethodSource("generateListsOfNumbers")
    @DisplayName("Should return sorted list of number when input is list of numbers")
    public void shouldReturnSortedListOfNumbersWhenInputIsListOfNumbers(List<Comparable> numbersToSort, List<Comparable> numbersInProperOrder)
    {
        sortedNumbers = BubbleSort.sort(numbersToSort);
        assertArrayEquals(numbersInProperOrder.toArray(), sortedNumbers.toArray());
    }

    static private Stream<Arguments> generateListsOfNumbers()
    {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 4, 5, 6, 8, 3, 8), Arrays.asList(1, 3, 4, 5, 6, 8, 8)),
                Arguments.of(Arrays.asList(-9.3, 0.2, 4, 0.1, 5, 9), Arrays.asList(-9.3, 0.1, 0.2, 4, 5, 9))
        );
    }

    @ParameterizedTest
    @MethodSource("generateListsOfNumbersAndNulls")
    @DisplayName("Should return sorted list of numbers when input is list of numbers and nulls")
    public void shouldReturnSortedListOfNumbersWhenInputIsListOfNumbersAndNulls(List<Comparable> numbersToSort, List<Comparable> numbersInProperOrder)
    {
        sortedNumbers = BubbleSort.sort(numbersToSort);
        assertArrayEquals(numbersInProperOrder.toArray(), sortedNumbers.toArray());
    }

    static private Stream<Arguments> generateListsOfNumbersAndNulls()
    {
        return Stream.of(
                Arguments.of(Arrays.asList(null, 5.0001), Arrays.asList(5.0001))
        );
    }

    @Test
    @DisplayName("Should return empty list when input list is empty")
    public void shouldReturnEmptyListWhenInputListIsEmpty()
    {
        sortedNumbers = BubbleSort.sort(new ArrayList<>());
        assertTrue(sortedNumbers.isEmpty());
    }

    @Test
    @DisplayName("Should throw runtime excetion when list of numbers is null")
    public void shouldThrowRuntimeExceptionWhenListOfNumbersIsNull()
    {
        assertThrows(RuntimeException.class, () -> BubbleSort.sort(null));
    }
}
