package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.f;
import com.google.android.gms.analytics.internal.k;
import com.google.android.gms.analytics.internal.q;
import com.google.android.gms.c.as;
import com.google.android.gms.common.internal.w;

public class CampaignTrackingReceiver extends BroadcastReceiver {
    static Object aEv = new Object();
    static as aEw;
    static Boolean aEx;

    public static boolean aa(Context context) {
        w.ah(context);
        if (aEx != null) {
            return aEx.booleanValue();
        }
        boolean a = k.a(context, CampaignTrackingReceiver.class, true);
        aEx = Boolean.valueOf(a);
        return a;
    }

    public void aG(String str) {
    }

    public Class<? extends CampaignTrackingService> mC() {
        return CampaignTrackingService.class;
    }

    public void onReceive(Context context, Intent intent) {
        f nr = q.ac(context).nr();
        String stringExtra = intent.getStringExtra("referrer");
        String action = intent.getAction();
        nr.d("CampaignTrackingReceiver received", action);
        if (!"com.android.vending.INSTALL_REFERRER".equals(action) || TextUtils.isEmpty(stringExtra)) {
            nr.aR("CampaignTrackingReceiver received unexpected intent without referrer extra");
            return;
        }
        boolean ab = CampaignTrackingService.ab(context);
        if (!ab) {
            nr.aR("CampaignTrackingService not registered or disabled. Installation tracking not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
        aG(stringExtra);
        if (com.google.android.gms.common.internal.f.aNr) {
            nr.aS("Received unexpected installation campaign on package side");
            return;
        }
        Class mC = mC();
        w.ah(mC);
        Intent intent2 = new Intent(context, mC);
        intent2.putExtra("referrer", stringExtra);
        synchronized (aEv) {
            context.startService(intent2);
            if (ab) {
                try {
                    if (aEw == null) {
                        as asVar = new as(context, "Analytics campaign WakeLock", (byte) 0);
                        aEw = asVar;
                        asVar.qt();
                    }
                    aEw.qr();
                } catch (SecurityException e) {
                    nr.aR("CampaignTrackingService service at risk of not starting. For more reliable installation campaign reports, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                }
                return;
            }
        }
    }
}
