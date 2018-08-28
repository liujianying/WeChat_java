package com.tencent.tinker.lib.service;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.tencent.tinker.lib.f.a;

public class TinkerPatchService$IntentServiceRunner$InnerService extends Service {
    public void onCreate() {
        super.onCreate();
        try {
            startForeground(TinkerPatchService.uw(), new Notification());
        } catch (Throwable th) {
            a.e("Tinker.TinkerPatchService", "InnerService set service for push exception:%s.", new Object[]{th});
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
