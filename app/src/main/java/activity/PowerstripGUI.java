package activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.ToggleButton;

import com.example.christian.socketpowerandroid.R;

import java.util.List;

import model.Outlet;

public class PowerstripGUI extends AppCompatActivity {

    Context context;
//    RESTClient restClient;
//    Client client;
//    FormatConversion fc;
//    List<Outlet> outlets;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = PowerstripGUI.this;
        setContentView(R.layout.powerstrip_control);

//        fc = new FormatConversion();
//
//        Client client = fc.convertJsonToClient(getString(R.string.sampleClient));
//
//        outlets = client.getDevices().get(0).getOutlets();


        Switch button1 = findViewById(R.id.switch1);
        Switch button2 = findViewById(R.id.switch2);
        Switch button3 = findViewById(R.id.switch3);
        Switch button4 = findViewById(R.id.switch4);
        Switch button5 = findViewById(R.id.switch5);
        Switch button6 = findViewById(R.id.switch6);

        button1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                Outlet outlet = outlets.get(0);
//                if (isChecked) {
//                    outlet.setOutlet_status(true);
//                    Outlet outletConfirm = restClient.outletToggle(outlet);
//                    outlets.set(0, outlet);
//                } else {
//                    outlet.setOutlet_status(false);
//                    Outlet outletConfirm = restClient.outletToggle(outlet);
//                    outlets.set(0, outlet);                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("PowerStrip2", "Pressed here");



            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("PowerStrip3", "Pressed here");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("PowerStrip4", "Pressed here");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("PowerStrip5", "Pressed here");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("PowerStrip6", "Pressed here");
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Hello Brannon", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }




}
