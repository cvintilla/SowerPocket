package activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.christian.socketpowerandroid.R;

public class PowerstripGUI extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = PowerstripGUI.this;
        setContentView(R.layout.powerstrip_control);


        Button button1;
        Button button2;
        Button button3;
        Button button4;
        Button button5;
        Button button6;

        button1 = findViewById(R.id.toggleButton1);
        button2 = findViewById(R.id.toggleButton2);
        button3 = findViewById(R.id.toggleButton3);
        button4 = findViewById(R.id.toggleButton4);
        button5 = findViewById(R.id.toggleButton5);
        button6 = findViewById(R.id.toggleButton6);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.d("PowerStrip1", "Pressed here");
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



    private void goToNextActivity(int animationIn, int animationOut) {
        Intent intent = new Intent(context, SelectDeviceGUI.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        overridePendingTransition(animationIn, animationOut);
    }

}
