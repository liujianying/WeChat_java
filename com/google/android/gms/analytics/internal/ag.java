package com.google.android.gms.analytics.internal;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.common.internal.w;

public final class ag extends o {
    boolean aHo;
    boolean aHp;
    private AlarmManager aHq = ((AlarmManager) this.aFn.mContext.getSystemService("alarm"));

    protected ag(q qVar) {
        super(qVar);
    }

    private PendingIntent oi() {
        Intent intent = new Intent(this.aFn.mContext, AnalyticsReceiver.class);
        intent.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
        return PendingIntent.getBroadcast(this.aFn.mContext, 0, intent, 0);
    }

    public final void cancel() {
        np();
        this.aHp = false;
        this.aHq.cancel(oi());
    }

    protected final void mE() {
        try {
            this.aHq.cancel(oi());
            if (ac.nX() > 0) {
                ActivityInfo receiverInfo = this.aFn.mContext.getPackageManager().getReceiverInfo(new ComponentName(this.aFn.mContext, AnalyticsReceiver.class), 2);
                if (receiverInfo != null && receiverInfo.enabled) {
                    aO("Receiver registered. Using alarm for local dispatch.");
                    this.aHo = true;
                }
            }
        } catch (NameNotFoundException e) {
        }
    }

    public final void oh() {
        np();
        w.d(this.aHo, "Receiver not registered");
        long nX = ac.nX();
        if (nX > 0) {
            cancel();
            long elapsedRealtime = this.aFn.aFC.elapsedRealtime() + nX;
            this.aHp = true;
            this.aHq.setInexactRepeating(2, elapsedRealtime, 0, oi());
        }
    }
}
