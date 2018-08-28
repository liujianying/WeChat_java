package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.ac;
import com.google.android.gms.analytics.internal.f;
import com.google.android.gms.analytics.internal.k;
import com.google.android.gms.analytics.internal.m;
import com.google.android.gms.analytics.internal.m.2;
import com.google.android.gms.analytics.internal.q;
import com.google.android.gms.c.as;
import com.google.android.gms.common.internal.w;

public class CampaignTrackingService extends Service {
    private static Boolean aEy;
    private Handler mHandler;

    public static boolean ab(Context context) {
        w.ah(context);
        if (aEy != null) {
            return aEy.booleanValue();
        }
        boolean a = k.a(context, CampaignTrackingService.class);
        aEy = Boolean.valueOf(a);
        return a;
    }

    protected final void a(f fVar, Handler handler, int i) {
        handler.post(new 3(this, i, fVar));
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        q.ac(this).nr().aO("CampaignTrackingService is starting up");
    }

    public void onDestroy() {
        q.ac(this).nr().aO("CampaignTrackingService is shutting down");
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        try {
            synchronized (CampaignTrackingReceiver.aEv) {
                as asVar = CampaignTrackingReceiver.aEw;
                if (asVar != null && asVar.aZe.isHeld()) {
                    asVar.release();
                }
            }
        } catch (SecurityException e) {
        }
        q ac = q.ac(this);
        f nr = ac.nr();
        String str = null;
        if (com.google.android.gms.common.internal.f.aNr) {
            nr.aS("Unexpected installation campaign (package side)");
        } else {
            str = intent.getStringExtra("referrer");
        }
        Handler handler = this.mHandler;
        if (handler == null) {
            handler = new Handler(getMainLooper());
            this.mHandler = handler;
        }
        if (TextUtils.isEmpty(str)) {
            if (!com.google.android.gms.common.internal.f.aNr) {
                nr.aR("No campaign found on com.android.vending.INSTALL_REFERRER \"referrer\" extra");
            }
            ac.ns().d(new 1(this, nr, handler, i2));
        } else {
            int nV = ac.nV();
            if (str.length() > nV) {
                nr.c("Campaign data exceed the maximum supported size and will be clipped. size, limit", Integer.valueOf(str.length()), Integer.valueOf(nV));
                str = str.substring(0, nV);
            }
            nr.a("CampaignTrackingService called. startId, campaign", Integer.valueOf(i2), str);
            m nt = ac.nt();
            2 2 = new 2(this, nr, handler, i2);
            w.i(str, "campaign param can't be empty");
            nt.aFn.ns().d(new 2(nt, str, 2));
        }
        return 2;
    }
}
