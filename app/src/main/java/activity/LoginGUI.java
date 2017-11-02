package activity;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

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
        Button login_button = findViewById(R.id.email_sign_in_button);
        login_button.setOnClickListener(this);
    }

    private void goToNextActivity(int animationIn, int animationOut) {
        Intent intent = new Intent(context, SelectDeviceGUI.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        overridePendingTransition(animationIn, animationOut);
    }

    public int whatComesIn() {
        return 1;
    }

    public String getUserText() {
        TextView Username = (TextView) findViewById(R.id.username_input_text);
        TextView Password = (TextView) findViewById(R.id.password_input_text);

        String userUsername = Username.getText().toString();
        String userPassword = Password.getText().toString();
        String toGio = (userUsername + " " + userPassword).toString();

        return toGio;
    }

    @Override
    public void onClick(View v) {
        //if view is equal to the button
        if (v.getId() == R.id.email_sign_in_button) {
            //username and password validation
            if (whatComesIn() == -2) {
                //error
                Snackbar.make(v, "ERROR #671", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            } else if (whatComesIn() == -1) {
                //invalid login
                Snackbar.make(v, "Invalid Login", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            } else if (whatComesIn() == 1) {
                Log.v("TEXT TO GIO IS: ", getUserText());

                //transition to next activity
                goToNextActivity(R.anim.fade_in, R.anim.fade_out);

            }

        }
    }

}
