package mockito;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.atMostOnce;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BasicTest {

    List mockedList = mock(List.class);
    List mockedLinkedList = mock(LinkedList.class);

    @Test
    void behaviourTest(){
        mockedList.add("one");
        mockedList.clear();

        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    @Test
    void stubbing(){
        when(mockedLinkedList.get(0)).thenReturn("first");
        when(mockedLinkedList.get(1)).thenThrow(new RuntimeException());

        System.out.println(mockedLinkedList.get(0));
//        System.out.println(mockedLinkedList.get(1));

        System.out.println(mockedLinkedList.get(99));   //not stub

        verify(mockedLinkedList).get(0);
    }

    @Test
    void argumentMatcher(){
        when(mockedList.get(anyInt())).thenReturn("element");

        System.out.println(mockedList.get(999));

        verify(mockedList).get(anyInt());
    }

    @Test
    void verifyingExactNumber(){
        mockedList.add("once");
        mockedList.add("twice");
        mockedList.add("twice");
        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        verify(mockedList).add("once");
        verify(mockedList, times(1)).add("once");
        verify(mockedList, times(2)).add("twice");
        verify(mockedList, times(3)).add("three times");

        verify(mockedList, never()).add("never happened");

        verify(mockedList, atMostOnce()).add("once");
        verify(mockedList, atLeastOnce()).add("three times");
        verify(mockedList, atLeast(2)).add("three times");
    }

    @Test
    void stubbingVoidMethodWithException(){
        doThrow(new RuntimeException()).when(mockedList).clear();

        mockedList.clear();
    }
}

