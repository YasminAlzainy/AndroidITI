package yasmin.ayman.alzainy.myfirebase.cloudMessaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class MyBroadcastReceiver extends BroadcastReceiver {
    public static final String TOAST_STRING = "toast_string" ;

    @Override
    public void onReceive(Context context, Intent intent) {
        String toastString = "No data";
        if (intent.getExtras() != null) {
            toastString = "";
            for (String key : intent.getExtras().keySet()) {
                String value = intent.getExtras().getString(key);
                toastString += key + ": " +value + "\n";
            }
        }

        Intent myNewActivity = new Intent(context.getApplicationContext(), CloudMessage.class);
        myNewActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        myNewActivity.putExtra(TOAST_STRING , toastString);
        context.startActivity(myNewActivity);
    }
}
