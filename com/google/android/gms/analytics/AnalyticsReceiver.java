package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.internal.f;
import com.google.android.gms.analytics.internal.k;
import com.google.android.gms.analytics.internal.q;
import com.google.android.gms.c.as;
import com.google.android.gms.common.internal.w;

public final class AnalyticsReceiver extends BroadcastReceiver {
    static Object aEv = new Object();
    static as aEw;
    static Boolean aEx;

    public static boolean aa(Context context) {
        w.ah(context);
        if (aEx != null) {
            return aEx.booleanValue();
        }
        boolean a = k.a(context, AnalyticsReceiver.class, false);
        aEx = Boolean.valueOf(a);
        return a;
    }

    public final void onReceive(Context context, Intent intent) {
        f nr = q.ac(context).nr();
        String action = intent.getAction();
        if (com.google.android.gms.common.internal.f.aNr) {
            nr.d("Device AnalyticsReceiver got", action);
        } else {
            nr.d("Local AnalyticsReceiver got", action);
        }
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            boolean ab = AnalyticsService.ab(context);
            Intent intent2 = new Intent(context, AnalyticsService.class);
            intent2.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            synchronized (aEv) {
                context.startService(intent2);
                if (ab) {
                    try {
                        if (aEw == null) {
                            as asVar = new as(context, "Analytics WakeLock", (byte) 0);
                            aEw = asVar;
                            asVar.qt();
                        }
                        aEw.qr();
                    } catch (SecurityException e) {
                        nr.aR("Analytics service at risk of not starting. For more reliable analytics, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                    }
                    return;
                }
                return;
            }
        }
        return;
    }
}
