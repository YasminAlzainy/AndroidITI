package yasmin.ayman.alzainy.myfirebase.cloudMessaging;

import android.content.IntentFilter;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import yasmin.ayman.alzainy.myfirebase.R;

public class CloudMessage extends AppCompatActivity {

    public static final String TAG = "RegistrationToken";
    private Button btnRegistrationToken;
    private IntentFilter messageIntentFilter;
    private MyBroadcastReceiver broadcastReceiver;
    private String toastString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cloud_message);

        messageIntentFilter = new IntentFilter("yasmin.ayman.alzainy.CloudMessage");
        broadcastReceiver = new MyBroadcastReceiver();
        registerReceiver(broadcastReceiver, messageIntentFilter);

        toastString = getIntent().getStringExtra(MyBroadcastReceiver.TOAST_STRING);
        if (toastString != null) {
            Toast.makeText(this, toastString, Toast.LENGTH_SHORT).show();
        }
        btnRegistrationToken = findViewById(R.id.btnRegistrationToken);
        btnRegistrationToken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {

                        if (!task.isSuccessful()) {
                            Toast.makeText(CloudMessage.this, "getInstanceId() Fail", Toast.LENGTH_SHORT).show();
                        } else {

                            String token = task.getResult().getToken();
                            Log.i(TAG, "Token is: " + token);
                            Toast.makeText(CloudMessage.this, "Token is: " + token, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(broadcastReceiver);
    }
}
