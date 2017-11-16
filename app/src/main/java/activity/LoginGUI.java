package activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.christian.socketpowerandroid.R;

public class LoginGUI extends AppCompatActivity implements View.OnClickListener{
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = LoginGUI.this;
        setContentView(R.layout.activity_main);
        initializeViews();
    }

    public void initializeViews() {
        Button login_button = findViewById(R.id.start_button);
        login_button.setOnClickListener(this);
    }

    private void goToNextActivity(int animationIn, int animationOut) {
        Intent intent = new Intent(context, PowerstripGUI.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        overridePendingTransition(R.anim.slide_down, R.anim.slide_down);
    }


    @Override
    public void onClick(View v) {
        //if view is equal to the button
        if (v.getId() == R.id.start_button) {
            //username and password validation

            //transition to next activity
            goToNextActivity(R.anim.fade_in, R.anim.fade_out);
        }
    }

}
