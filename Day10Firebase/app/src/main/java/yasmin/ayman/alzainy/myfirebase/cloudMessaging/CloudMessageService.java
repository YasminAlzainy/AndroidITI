package yasmin.ayman.alzainy.myfirebase.cloudMessaging;

import android.content.Intent;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

public class CloudMessageService extends FirebaseMessagingService {
    private static final String TAG = "message";
    public static final String MESSEGES_SET = "messeges_set";

    public CloudMessageService() {
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);

        Log.i(TAG, "getFrom: " + remoteMessage.getFrom());
        Log.i(TAG, "getTtl: " + String.valueOf(remoteMessage.getTtl()));
        Log.i(TAG, "getSentTime: " + String.valueOf(remoteMessage.getSentTime()));

        if (remoteMessage.getMessageType() != null)
            Log.i(TAG, "getMessageType: " + remoteMessage.getMessageType());

        if (remoteMessage.getNotification() != null) {
            Log.i(TAG, remoteMessage.getNotification().getTitle());
            Log.i(TAG, remoteMessage.getNotification().getBody());
        }

        if( remoteMessage.getData().size() > 0) {
            Log.i(TAG, String.valueOf(remoteMessage.getData()));
            Intent intent = null;
            intent = new Intent(this, CloudMessage.class);
            for (String key : remoteMessage.getData().keySet()) {
                intent.putExtra(key, remoteMessage.getData().get(key));
            }
            intent.setAction("yasmin.ayman.alzainy.CloudMessage");
            sendBroadcast(intent);
        }

    }

    @Override
    public void onDeletedMessages() {
        super.onDeletedMessages();
    }
}
