package activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.christian.socketpowerandroid.R;

/**
 * Created by Christian on 10/21/2017.
 */
public class SelectDeviceGUI extends AppCompatActivity implements View.OnClickListener {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = SelectDeviceGUI.this;
        setContentView(R.layout.select_device);
        initializeViews();

    }

    public void initializeViews() {
        Button login_button = findViewById(R.id.button3);
        login_button.setOnClickListener(this);

    }

    private void goToNextActivity(int animationIn, int animationOut) {
        Intent intent = new Intent(context, PowerstripGUI.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        overridePendingTransition(animationIn, animationOut);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button3) {
            goToNextActivity(R.anim.fade_in, R.anim.fade_out);
        }
    }

}

