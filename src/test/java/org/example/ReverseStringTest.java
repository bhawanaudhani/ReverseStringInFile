package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.commons.util.ReflectionUtils;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.powermock.api.mockito.PowerMockito;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;


@ExtendWith(MockitoExtension.class)
class ReverseStringTest {



    @Captor
    ArgumentCaptor<String> text;


    /**
     * Test the successful reversal of File
     * @throws Exception
     */
    @Test
    public void testReverseString() throws Exception {
        BufferedWriter mockeBufferedWriter = Mockito.mock(BufferedWriter.class);
        InputStream inStream =  new ByteArrayInputStream("Test".getBytes(StandardCharsets.UTF_8));

        ReverseString reverseString = Mockito.spy(new ReverseString(inStream,mockeBufferedWriter));

        reverseString.reverse();
        Mockito.verify(mockeBufferedWriter).write(text.capture());
        Assertions.assertEquals("tseT",text.getValue());
    }

    /**
     * Test the successful reversal of multiline text
     * @throws Exception
     */
    @Test
    public void testMulitLineTest() throws Exception {
        String s = "It was the best of times, it was the worst of times,\n"
                + "it was the age of wisdom, it was the age of foolishness,\n";
        BufferedWriter mockeBufferedWriter = Mockito.mock(BufferedWriter.class);
        InputStream inStream =  new ByteArrayInputStream(s.getBytes(StandardCharsets.UTF_8));

        ReverseString reverseString = Mockito.spy(new ReverseString(inStream,mockeBufferedWriter));

        reverseString.reverse();
        Mockito.verify(mockeBufferedWriter,Mockito.times(2)).write(anyString());

    }

    /**
     * Test the failure in case finding the input file
     * @throws Exception
     */
    @Test
    public void testReverseString_FailureInputStream() throws Exception {
        BufferedWriter mockeBufferedWriter = Mockito.mock(BufferedWriter.class);
        InputStream inStream =  null;
        ReverseString reverseString = Mockito.spy(new ReverseString(inStream,mockeBufferedWriter));

        reverseString.reverse();

        Mockito.verify(mockeBufferedWriter,Mockito.times(0)).write(anyString());
    }



}