package com.tencent.mm.booter;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.mm.sdk.platformtools.x;

public class CoreService$InnerService extends Service {
    public void onCreate() {
        super.onCreate();
        try {
            startForeground(-1213, new Notification());
        } catch (NullPointerException e) {
            x.e("MicroMsg.CoreService", "set service for push exception:%s.", new Object[]{e});
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
