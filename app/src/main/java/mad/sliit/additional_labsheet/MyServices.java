package mad.sliit.additional_labsheet;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;
import android.view.View;

import androidx.annotation.Nullable;

public class MyServices extends Service {
    @Nullable

    private MediaPlayer mediaPlayer;

    public int onStartCommand(Intent intent, int flags, int startId) {


        mediaPlayer = MediaPlayer.create(this,
                Settings.System.DEFAULT_NOTIFICATION_URI);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        return START_STICKY;
    }


    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }



}
