package com.tencent.mm.booter;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.x;

public class TrafficStatsReceiver extends BroadcastReceiver {
    private long mLastTime = -1;

    public void onReceive(Context context, Intent intent) {
        x.d("MicroMsg.TrafficStats", "onRecieve");
        long elapsedRealtime = SystemClock.elapsedRealtime();
        bh.update();
        if (this.mLastTime >= 0) {
            long j = elapsedRealtime - this.mLastTime;
            long ciQ = bh.ciQ() + bh.ciP();
            long ciO = bh.ciO() + bh.ciN();
            long ciU = bh.ciU() + bh.ciT();
            long ciU2 = bh.ciU() + bh.ciT();
            x.i("MicroMsg.TrafficStats", "Time: %d ms, System - [Mobile: %d, Wifi: %d, Speed: %.2f], WeChat - [Mobile: %d, Wifi: %d, Speed: %.2f]", new Object[]{Long.valueOf(j), Long.valueOf(ciQ), Long.valueOf(ciO), Double.valueOf(((double) (ciQ + ciO)) / ((double) (j / 1000))), Long.valueOf(ciU), Long.valueOf(ciU2), Double.valueOf(((double) (ciU + ciU2)) / ((double) (j / 1000)))});
        }
        this.mLastTime = elapsedRealtime;
    }

    public static void bo(Context context) {
        ((AlarmManager) context.getSystemService("alarm")).setRepeating(3, SystemClock.elapsedRealtime(), 300000, PendingIntent.getBroadcast(context, 1, new Intent("com.tencent.mm.TrafficStatsReceiver"), 268435456));
        x.i("MicroMsg.TrafficStats", "Register alarm, interval: %d ms", new Object[]{Long.valueOf(300000)});
    }

    public static void bp(Context context) {
        ((AlarmManager) context.getSystemService("alarm")).cancel(PendingIntent.getBroadcast(context, 1, new Intent("com.tencent.mm.TrafficStatsReceiver"), 268435456));
    }
}
