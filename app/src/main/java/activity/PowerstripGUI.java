package activity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.speech.RecognizerIntent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
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
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PowerstripGUI extends AppCompatActivity {

    Context context;
    Client client;
    FormatConversion fc;
    List<Outlet> outlets;
    String responseAwesome;
    private List<Switch> switchList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = PowerstripGUI.this;
        setContentView(R.layout.powerstrip_control);

        switchList = new ArrayList<>();
        fc = new FormatConversion();

        client = fc.convertJsonToClient(getString(R.string.sampleClient));

        outlets = client.getDevices().get(0).getOutlets();

        Switch button1 = findViewById(R.id.switch1);
        Switch button2 = findViewById(R.id.switch2);
        Switch button3 = findViewById(R.id.switch3);
        Switch button4 = findViewById(R.id.switch4);
        Switch button5 = findViewById(R.id.switch5);
        Switch button6 = findViewById(R.id.switch6);

        switchList.add(button1);
        switchList.add(button2);
        switchList.add(button3);
        switchList.add(button4);
        switchList.add(button5);
        switchList.add(button6);


        button1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    Log.d("INFO:", "YOU PRESSED ME ON");
                    RESTClient client = new RESTClient();
                    client.outletToggleDirect(true, "1");

                } else {
                    Log.d("INFO:", "YOU PRESSED ME OFF");
                    RESTClient client = new RESTClient();

                    client.outletToggleDirect(false, "1");

                }

            }
        });

        button2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    Log.d("INFO:", "YOU PRESSED ME ON");
                    RESTClient client = new RESTClient();
                    client.outletToggleDirect(true, "2");

                } else {
                    Log.d("INFO:", "YOU PRESSED ME OFF");
                    RESTClient client = new RESTClient();

                    client.outletToggleDirect(false, "2");

                }

            }
        });

        button3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    Log.d("INFO:", "YOU PRESSED ME ON");
                    RESTClient client = new RESTClient();
                    client.outletToggleDirect(true, "3");

                } else {
                    Log.d("INFO:", "YOU PRESSED ME OFF");
                    RESTClient client = new RESTClient();

                    client.outletToggleDirect(false, "3");

                }

            }
        });

        button4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    Log.d("INFO:", "YOU PRESSED ME ON");
                    RESTClient client = new RESTClient();
                    client.outletToggleDirect(true, "4");

                } else {
                    Log.d("INFO:", "YOU PRESSED ME OFF");
                    RESTClient client = new RESTClient();

                    client.outletToggleDirect(false, "4");

                }

            }
        });

        button5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    Log.d("INFO:", "YOU PRESSED ME ON");
                    RESTClient client = new RESTClient();
                    client.outletToggleDirect(true, "5");

                } else {
                    Log.d("INFO:", "YOU PRESSED ME OFF");
                    RESTClient client = new RESTClient();

                    client.outletToggleDirect(false, "5");

                }

            }
        });

        button6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    Log.d("INFO:", "YOU PRESSED ME ON");
                    RESTClient client = new RESTClient();
                    client.outletToggleDirect(true, "6");

                } else {
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

                    Snackbar.make(view, "Hello Brannon", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
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
            Toast.makeText(PowerstripGUI.this, "Sorry! Your device deosn't support speech language!", Toast.LENGTH_LONG).show();

        }
    }

    public void onActivityResult(int request_code, int result_code, Intent i) {
        super.onActivityResult(request_code, result_code, i);

        switch(request_code){
            case 100: if(result_code == RESULT_OK && i != null){
                List<String> result = i.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                TextEngine textEngine = new TextEngine();
                textEngine.executeTextCommand(result.get(0), switchList);
            }
                break;
        }
    }


}
