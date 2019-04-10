package yasmin.ayman.alzainy.myfirebase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import yasmin.ayman.alzainy.myfirebase.cloudMessaging.CloudMessage;

public class MainActivity extends AppCompatActivity {

    private Button btnSignIn, btnCloudMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSignIn = new Intent(MainActivity.this, SignIn.class);
                startActivity(intentSignIn);
            }
        });

        btnCloudMessage = findViewById(R.id.btnCloudMessage);
        btnCloudMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cloudMessageIntent = new Intent(MainActivity.this, CloudMessage.class);
                startActivity(cloudMessageIntent);
            }
        });

    }
}
