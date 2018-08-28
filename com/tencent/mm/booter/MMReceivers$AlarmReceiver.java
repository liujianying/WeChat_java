package com.tencent.mm.booter;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.network.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.x;

public class MMReceivers$AlarmReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (context != null && intent != null) {
            boolean booleanExtra = intent.getBooleanExtra("MMBoot_Bump", false);
            x.i("MicroMsg.AlarmReceiver", "[ALARM NOTIFICATION] bump:" + booleanExtra);
            if (booleanExtra) {
                bk(context);
            } else if (!b.v(context, "alarm")) {
                bn(context);
                x.chR();
            }
        }
    }

    public static void bk(Context context) {
        long chU = ab.chU();
        x.d("MicroMsg.AlarmReceiver", "bumper comes, next=" + chU);
        if (chU <= 1860000) {
            if (chU < 30000) {
                chU = 30000;
            }
            x.w("MicroMsg.AlarmReceiver", "reset bumper, interval=" + chU);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            if (alarmManager == null) {
                x.e("MicroMsg.AlarmReceiver", "keep bumper failed, null am");
                return;
            }
            alarmManager.set(0, chU + System.currentTimeMillis(), PendingIntent.getBroadcast(context, 1, new Intent(context, MMReceivers$AlarmReceiver.class).putExtra("MMBoot_Bump", true), 268435456));
        }
    }

    public static void bl(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            x.e("MicroMsg.AlarmReceiver", "stop bumper failed, null am");
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 1, new Intent(context, MMReceivers$AlarmReceiver.class).putExtra("MMBoot_Bump", true), 536870912);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
            broadcast.cancel();
        }
    }

    public static void bm(Context context) {
        x.w("MicroMsg.AlarmReceiver", "keep awaker");
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            x.e("MicroMsg.AlarmReceiver", "keep awaker failed, null am");
            return;
        }
        int i = aa.UU() ? 300000 : 900000;
        alarmManager.setRepeating(0, System.currentTimeMillis() + ((long) i), (long) i, PendingIntent.getBroadcast(context, 0, new Intent(context, MMReceivers$AlarmReceiver.class), 268435456));
    }

    public static void bn(Context context) {
        x.w("MicroMsg.AlarmReceiver", "stop awaker");
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            x.e("MicroMsg.AlarmReceiver", "keep awaker failed, null am");
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, new Intent(context, MMReceivers$AlarmReceiver.class), 536870912);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
            broadcast.cancel();
        }
    }
}
