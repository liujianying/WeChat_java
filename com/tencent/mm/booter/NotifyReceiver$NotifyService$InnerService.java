package com.tencent.mm.booter;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mm.sdk.platformtools.x;

public class NotifyReceiver$NotifyService$InnerService extends Service {
    public void onCreate() {
        super.onCreate();
        try {
            startForeground(-1212, new Notification());
        } catch (NullPointerException e) {
            x.e("MicroMsg.NotifyReceiver", "set service for mm exception:%s", new Object[]{e});
        }
        stopSelf();
    }

    public void onDestroy() {
        stopForeground(true);
        super.onDestroy();
    }

    public IBinder onBind(Intent intent) {
        return null;
    }
}
