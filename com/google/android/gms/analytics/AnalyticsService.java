package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import com.google.android.gms.analytics.internal.f;
import com.google.android.gms.analytics.internal.k;
import com.google.android.gms.analytics.internal.q;
import com.google.android.gms.c.as;
import com.google.android.gms.common.internal.w;

public final class AnalyticsService extends Service {
    private static Boolean aEy;
    private final Handler mHandler = new Handler();

    public static boolean ab(Context context) {
        w.ah(context);
        if (aEy != null) {
            return aEy.booleanValue();
        }
        boolean a = k.a(context, AnalyticsService.class);
        aEy = Boolean.valueOf(a);
        return a;
    }

    public final IBinder onBind(Intent intent) {
        return null;
    }

    public final void onCreate() {
        super.onCreate();
        f nr = q.ac(this).nr();
        if (com.google.android.gms.common.internal.f.aNr) {
            nr.aO("Device AnalyticsService is starting up");
        } else {
            nr.aO("Local AnalyticsService is starting up");
        }
    }

    public final void onDestroy() {
        f nr = q.ac(this).nr();
        if (com.google.android.gms.common.internal.f.aNr) {
            nr.aO("Device AnalyticsService is shutting down");
        } else {
            nr.aO("Local AnalyticsService is shutting down");
        }
        super.onDestroy();
    }

    public final int onStartCommand(Intent intent, int i, int i2) {
        try {
            synchronized (AnalyticsReceiver.aEv) {
                as asVar = AnalyticsReceiver.aEw;
                if (asVar != null && asVar.aZe.isHeld()) {
                    asVar.release();
                }
            }
        } catch (SecurityException e) {
        }
        q ac = q.ac(this);
        f nr = ac.nr();
        String action = intent.getAction();
        if (com.google.android.gms.common.internal.f.aNr) {
            nr.a("Device AnalyticsService called. startId, action", Integer.valueOf(i2), action);
        } else {
            nr.a("Local AnalyticsService called. startId, action", Integer.valueOf(i2), action);
        }
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            ac.nt().a(new 1(this, i2, ac, nr));
        }
        return 2;
    }
}
