package activity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.christian.socketpowerandroid.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import model.Client;
import model.Device;
import model.FormatConversion;
import model.Outlet;
import model.RESTClient;
import model.TextEngine;


public class PowerstripGUI extends AppCompatActivity {

    private int speakSlow = 3000;
    private TextToSpeech textToSpeech;
    private EditText editText;
    private int result;

    private Switch button1;
    private Switch button2;
    private Switch button3;
    private Switch button4;
    private Switch button5;
    private Switch button6;

    private String string1;
    private String string2;
    private String string3;
    private String string4;
    private String string5;
    private String string6;
    private String string1Off;
    private String string2Off;
    private String string3Off;
    private String string4Off;
    private String string5Off;
    private String string6Off;

    private List<String> stringList;

    Context context;
    Client client;
    FormatConversion fc;
    List<Outlet> outlets;
    private List<Switch> switchList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = PowerstripGUI.this;
        setContentView(R.layout.powerstrip_control);

        switchList = new ArrayList<>();
        fc = new FormatConversion();
        stringList = new ArrayList<>();

        client = fc.convertJsonToClient(getString(R.string.sampleClient));
        outlets = client.getDevices().get(0).getOutlets();

        button1 = findViewById(R.id.switch1);
        button2 = findViewById(R.id.switch2);
        button3 = findViewById(R.id.switch3);
        button4 = findViewById(R.id.switch4);
        button5 = findViewById(R.id.switch5);
        button6 = findViewById(R.id.switch6);

        switchList.add(button1);
        switchList.add(button2);
        switchList.add(button3);
        switchList.add(button4);
        switchList.add(button5);
        switchList.add(button6);


        string1 = ("Turning On Outlet One.");
        string2 = ("Turning On Outlet two.");
        string3 = ("Turning On Outlet three.");
        string4 = ("Turning On Outlet four.");
        string5 = ("Turning On Outlet five.");
        string6 = ("Turning On Outlet six, Mr. Za levski.");

        string1Off = ("Turning off Outlet One.");
        string2Off = ("Turning off Outlet two.");
        string3Off = ("Turning off Outlet three.");
        string4Off = ("Turning off Outlet four.");
        string5Off = ("Turning off Outlet five.");
        string6Off = ("Turning off Outlet six, Mr. Za levski.");


        editText = findViewById(R.id.editText);
        textToSpeech = new TextToSpeech(PowerstripGUI.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS){
                    result = textToSpeech.setLanguage(Locale.UK);
                }else{
                    Toast.makeText(getApplicationContext(),"Feature not supported on this device", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    editText.setText(string1);
                    textToSpeech.setLanguage(Locale.US);
                    string1 = editText.getText().toString();
                    textToSpeech.speak(string1, TextToSpeech.QUEUE_FLUSH, null);

                    Log.d("INFO:", "YOU PRESSED ME ON");
                    RESTClient client = new RESTClient();
                    client.outletToggleDirect(true, "1");

                } else {
                    editText.setText(string1Off);
                    string1Off = editText.getText().toString();
                    textToSpeech.speak(string1Off, TextToSpeech.QUEUE_FLUSH, null);

                    Log.d("INFO:", "YOU PRESSED ME OFF");
                    RESTClient client = new RESTClient();
                    client.outletToggleDirect(false, "1");

                }

            }
        });

        button2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    editText.setText(string2);
                    string2 = editText.getText().toString();
                    textToSpeech.speak(string2, TextToSpeech.QUEUE_FLUSH, null);

                    Log.d("INFO:", "YOU PRESSED ME ON");
                    RESTClient client = new RESTClient();
                    client.outletToggleDirect(true, "2");

                } else {
                    editText.setText(string2Off);
                    string2Off = editText.getText().toString();
                    textToSpeech.speak(string2Off, TextToSpeech.QUEUE_FLUSH, null);

                    Log.d("INFO:", "YOU PRESSED ME OFF");
                    RESTClient client = new RESTClient();
                    client.outletToggleDirect(false, "2");

                }

            }
        });

        button3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    editText.setText(string3);
                    string3 = editText.getText().toString();
                    textToSpeech.speak(string3, TextToSpeech.QUEUE_FLUSH, null);

                    Log.d("INFO:", "YOU PRESSED ME ON");
                    RESTClient client = new RESTClient();
                    client.outletToggleDirect(true, "3");

                } else {
                    editText.setText(string3Off);
                    string3Off = editText.getText().toString();
                    textToSpeech.speak(string3Off, TextToSpeech.QUEUE_FLUSH, null);

                    Log.d("INFO:", "YOU PRESSED ME OFF");
                    RESTClient client = new RESTClient();
                    client.outletToggleDirect(false, "3");

                }

            }
        });

        button4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    editText.setText(string4);
                    string4 = editText.getText().toString();
                    textToSpeech.speak(string4, TextToSpeech.QUEUE_FLUSH, null);

                    Log.d("INFO:", "YOU PRESSED ME ON");
                    RESTClient client = new RESTClient();
                    client.outletToggleDirect(true, "4");

                } else {
                    editText.setText(string4Off);
                    string4Off = editText.getText().toString();
                    textToSpeech.speak(string4Off, TextToSpeech.QUEUE_FLUSH, null);

                    Log.d("INFO:", "YOU PRESSED ME OFF");
                    RESTClient client = new RESTClient();
                    client.outletToggleDirect(false, "4");

                }

            }
        });

        button5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    editText.setText(string5);
                    string5 = editText.getText().toString();
                    textToSpeech.speak(string5, TextToSpeech.QUEUE_FLUSH, null);

                    Log.d("INFO:", "YOU PRESSED ME ON");
                    RESTClient client = new RESTClient();
                    client.outletToggleDirect(true, "5");

                } else {
                    editText.setText(string5Off);
                    string5Off = editText.getText().toString();
                    textToSpeech.speak(string5Off, TextToSpeech.QUEUE_FLUSH, null);

                    Log.d("INFO:", "YOU PRESSED ME OFF");
                    RESTClient client = new RESTClient();
                    client.outletToggleDirect(false, "5");

                }

            }
        });

        button6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    editText.setText(string6);
                    string6 = editText.getText().toString();
                    textToSpeech.speak(string6, TextToSpeech.QUEUE_FLUSH, null);

                    Log.d("INFO:", "YOU PRESSED ME ON");
                    RESTClient client = new RESTClient();
                    client.outletToggleDirect(true, "6");

                } else {
                    editText.setText(string6Off);
                    string6Off = editText.getText().toString();
                    textToSpeech.speak(string6Off, TextToSpeech.QUEUE_FLUSH, null);

                    Log.d("INFO:", "YOU PRESSED ME OFF");
                    RESTClient client = new RESTClient();
                    client.outletToggleDirect(false, "6");

                }

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                {
                    promptSpeechInput();
                }
            }
        });
    }
    public void promptSpeechInput() {
        Intent i = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        i.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        i.putExtra(RecognizerIntent.EXTRA_PROMPT, "Say something!");

        try {
            startActivityForResult(i, 100);
        } catch (Exception e) {
            Toast.makeText(PowerstripGUI.this, "Sorry! Your device doesn't support speech language!", Toast.LENGTH_LONG).show();

        }
    }

    public void onActivityResult(int request_code, int result_code, Intent i) {
        super.onActivityResult(request_code, result_code, i);

        switch(request_code){
            case 100: if(result_code == RESULT_OK && i != null){
                List<String> result = i.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                TextEngine textEngine = new TextEngine();
                textEngine.executeTextCommand(result.get(0), switchList);}
                break;
        }
    }
}
