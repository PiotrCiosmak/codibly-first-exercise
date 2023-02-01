package com.ciosmak.bubblesort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BubbleSort
{
    static public List<Comparable> sort(List<Comparable> input)
    {
        try
        {
            assertIsNotNull(input);
            input = removeAllNullElementsIfExists(input);

            return bubbleSortAlgorithm(input);
        }
        catch (RuntimeException e)
        {
            throw e;
        }
    }

    static private List<Comparable> bubbleSortAlgorithm(List<Comparable> numbers)
    {
        int numberOfElementsInInputList = numbers.size();
        for (int i = 0; i < numberOfElementsInInputList - 1; i++)
        {
            for (int j = 0; j < numberOfElementsInInputList - i - 1; j++)
            {
                Comparable firstElement = numbers.get(j);
                Comparable secondElement = numbers.get(j + 1);
                if (firstElement instanceof Number && secondElement instanceof Number)
                {
                    double firstValue = ((Number) firstElement).doubleValue();
                    double secondValue = ((Number) secondElement).doubleValue();
                    if (firstValue > secondValue)
                    {
                        Collections.swap(numbers, j, j + 1);
                    }
                }
                else if (firstElement.compareTo(secondElement) > 0)
                {
                    Collections.swap(numbers, j, j + 1);
                }
            }
        }
        return numbers;
    }

    static private void assertIsNotNull(List<Comparable> numbers)
    {
        if (numbers == null)
        {
            throw new RuntimeException("List of numbers can't be null");
        }
    }

    static private List<Comparable> removeAllNullElementsIfExists(List<Comparable> numbers)
    {
        List<Comparable> numberWithoutNulls = new ArrayList<>(numbers.size());
        for (var element : numbers)
        {
            if (element != null)
            {
                numberWithoutNulls.add(element);
            }
        }
        return numberWithoutNulls;
    }
}
