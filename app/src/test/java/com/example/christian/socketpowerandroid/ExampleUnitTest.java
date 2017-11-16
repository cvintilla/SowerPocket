package com.example.christian.socketpowerandroid;

import android.speech.tts.TextToSpeech;

import org.junit.Test;

import java.util.Locale;

import activity.PowerstripGUI;
import model.TextEngine;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void speechOutput(){
        String text;
        TextEngine textEngine = new TextEngine();
        //text = textEngine.getCommand();
      //  System.out.println(text);
    }
}