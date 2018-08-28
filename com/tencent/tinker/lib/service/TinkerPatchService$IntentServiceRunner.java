package com.tencent.tinker.lib.service;

import android.app.IntentService;
import android.app.Notification;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.tinker.lib.f.a;

public class TinkerPatchService$IntentServiceRunner extends IntentService {
    public TinkerPatchService$IntentServiceRunner() {
        super("TinkerPatchService");
    }

    protected void onHandleIntent(Intent intent) {
        if (VERSION.SDK_INT >= 26) {
            a.i("Tinker.TinkerPatchService", "for system version >= Android O, we just ignore increasingPriority job to avoid crash or toasts.", new Object[0]);
        } else if ("ZUK".equals(Build.MANUFACTURER)) {
            a.i("Tinker.TinkerPatchService", "for ZUK device, we just ignore increasingPriority job to avoid crash.", new Object[0]);
        } else {
            a.i("Tinker.TinkerPatchService", "try to increase patch process priority", new Object[0]);
            try {
                Notification notification = new Notification();
                if (VERSION.SDK_INT < 18) {
                    startForeground(TinkerPatchService.uw(), notification);
                } else {
                    startForeground(TinkerPatchService.uw(), notification);
                    startService(new Intent(this, InnerService.class));
                }
            } catch (Throwable th) {
                a.i("Tinker.TinkerPatchService", "try to increase patch process priority error:" + th, new Object[0]);
            }
        }
        TinkerPatchService.F(getApplicationContext(), intent);
    }
}
