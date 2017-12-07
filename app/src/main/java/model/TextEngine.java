package model;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.christian.socketpowerandroid.R;

import org.w3c.dom.Text;

import activity.PowerstripGUI;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * Created by bccenten on 11/1/2017.
 */

public class TextEngine extends AppCompatActivity {

    // variables
    private TextToSpeech t1;
    private EditText editText;
    private TextEngine textEngine;
    private int result;
    private Context context;
    private String command;
    private String reply;
    private Switch button1;
    private String toSpeak = "your mom";

    public TextEngine() {

    }


    public void executeTextCommand(String text, List<Switch> mySwitchList) {
//        Bundle newInstance = new Bundle();
        command = text.toUpperCase();
        RESTClient client = new RESTClient();
        List<String> wordList = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(command);


        while (st.hasMoreTokens()) {
            wordList.add(st.nextToken());
        }

//        textToSpeech.setLanguage(Locale.US);
//                    textToSpeech.speak(reply, TextToSpeech.QUEUE_FLUSH, null);

        if (wordList.contains("ON")) {

            if (command.contains("1") || command.contains("ONE") || command.contains("WON") || command.contains("JUAN")) {
//                onCreate(newInstance);
                client.outletToggleDirect(true, "1");
                mySwitchList.get(0).setChecked(true);
//                new SendCommandToServer().doInBackground("turn on outlet 1");
            } else if (command.contains("2") || command.contains("TWO") || command.contains("TO") || command.contains("TOO")) {
                client.outletToggleDirect(true, "2");
                mySwitchList.get(1).setChecked(true);

            } else if (command.contains("3") || command.contains("THREE")) {
                client.outletToggleDirect(true, "3");
                mySwitchList.get(2).setChecked(true);

            } else if (command.contains("4") || command.contains("FOUR") || command.contains("FOR") || command.contains("FORE")) {
                client.outletToggleDirect(true, "4");
                mySwitchList.get(3).setChecked(true);

            } else if (command.contains("5") || command.contains("FIVE")) {
                client.outletToggleDirect(true, "5");
                mySwitchList.get(4).setChecked(true);


            } else if (command.contains("6") || command.contains("SIX")) {
                client.outletToggleDirect(true, "6");
                mySwitchList.get(5).setChecked(true);

            } else {

            }


        } else if (command.contains("OFF")) {

            if (command.contains("1") || command.contains("ONE") || command.contains("WON") || command.contains("JUAN")) {
                client.outletToggleDirect(false, "1");
                mySwitchList.get(0).setChecked(false);

            }
        } else if (command.contains("2") || command.contains("TWO") || command.contains("TO") || command.contains("TOO")) {
            client.outletToggleDirect(false, "2");
            mySwitchList.get(1).setChecked(false);


        } else if (command.contains("3") || command.contains("THREE")) {
            client.outletToggleDirect(false, "3");
            mySwitchList.get(2).setChecked(false);


        } else if (command.contains("4") || command.contains("FOUR") || command.contains("FOR") || command.contains("FORE")) {
            client.outletToggleDirect(false, "4");
            mySwitchList.get(3).setChecked(false);

        } else if (command.contains("5") || command.contains("FIVE")) {
            client.outletToggleDirect(false, "5");
            mySwitchList.get(4).setChecked(false);

        } else if (command.contains("6") || command.contains("SIX")) {
            client.outletToggleDirect(false, "6");
            mySwitchList.get(5).setChecked(false);

        } else {

        }
    }

//    public void onPause() {
//        if (t1 != null) {
//            t1.stop();
//            t1.shutdown();
//        }
//        super.onPause();
//    }
//
//    public class SendCommandToServer extends AsyncTask<String, Void, String> {
//
//        @Override
//        protected String doInBackground(String... strings) {
//
//            t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
//                @Override
//                public void onInit(int status) {
//                    if (status != TextToSpeech.ERROR) {
//                        t1.setLanguage(Locale.UK);
//                    }
//                }
//            });
//
//            t1.speak(strings[0], TextToSpeech.QUEUE_FLUSH, null);
//
//            return "nothing";
//
//        }
//
//        @Override
//        protected void onPostExecute(String s) {
//            super.onPostExecute(s);
//        }

}

