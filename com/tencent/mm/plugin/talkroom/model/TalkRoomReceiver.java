package com.tencent.mm.plugin.talkroom.model;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.x;

public class TalkRoomReceiver extends BroadcastReceiver {
    protected static void init() {
        ab.a(new 1());
    }

    public void onReceive(Context context, Intent intent) {
        x.i("MicroMsg.TalkRoomReceiver", "[ALARM NOTIFICATION] bump:" + intent.getBooleanExtra("MMBoot_Bump", false));
        bk(context);
    }

    public static void bk(Context context) {
        long chU = ab.chU();
        x.d("MicroMsg.TalkRoomReceiver", "bumper comes, next=" + chU);
        if (chU <= 600000) {
            if (chU < 30000) {
                chU = 30000;
            }
            x.w("MicroMsg.TalkRoomReceiver", "reset bumper, interval:%d, now:%d", new Object[]{Long.valueOf(chU), Long.valueOf(SystemClock.elapsedRealtime())});
            AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
            if (alarmManager == null) {
                x.e("MicroMsg.TalkRoomReceiver", "keep bumper failed, null am");
                return;
            }
            alarmManager.set(2, chU + r4, PendingIntent.getBroadcast(context, 1, new Intent(context, TalkRoomReceiver.class).putExtra("MMBoot_Bump", true), 268435456));
        }
    }

    public static void bl(Context context) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService("alarm");
        if (alarmManager == null) {
            x.e("MicroMsg.TalkRoomReceiver", "stop bumper failed, null am");
            return;
        }
        PendingIntent broadcast = PendingIntent.getBroadcast(context, 1, new Intent(context, TalkRoomReceiver.class).putExtra("MMBoot_Bump", true), 536870912);
        if (broadcast != null) {
            alarmManager.cancel(broadcast);
            broadcast.cancel();
        }
    }
}
