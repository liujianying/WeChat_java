package com.tencent.mm.plugin.sport;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.tencent.mm.plugin.sport.c.g.a;
import com.tencent.mm.plugin.sport.c.n;
import com.tencent.mm.plugin.sport.service.SportService;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Calendar;
import java.util.Random;

class PluginSport$1 implements a {
    final /* synthetic */ PluginSport ooF;

    PluginSport$1(PluginSport pluginSport) {
        this.ooF = pluginSport;
    }

    public final void bFt() {
        if (PluginSport.access$000(this.ooF) != null) {
            PluginSport.access$000(this.ooF).bFE();
        }
        if (n.ei(ad.getContext()) && n.bFv()) {
            Context context = ad.getContext();
            AlarmManager alarmManager = (AlarmManager) ad.getContext().getSystemService("alarm");
            Calendar instance = Calendar.getInstance();
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            Random random = new Random();
            instance.set(11, 6);
            long timeInMillis = instance.getTimeInMillis() + ((long) random.nextInt(1800000));
            instance.set(11, 12);
            long timeInMillis2 = instance.getTimeInMillis() + ((long) random.nextInt(1800000));
            instance.set(11, 18);
            long timeInMillis3 = instance.getTimeInMillis() + ((long) random.nextInt(1800000));
            instance.set(11, 21);
            long timeInMillis4 = instance.getTimeInMillis() + ((long) random.nextInt(1800000));
            instance.set(11, 24);
            long timeInMillis5 = instance.getTimeInMillis() + ((long) random.nextInt(1800000));
            Intent intent = new Intent(context, SportService.class);
            intent.setFlags(268435456);
            try {
                alarmManager.setRepeating(0, timeInMillis, 86400000, PendingIntent.getService(context, 20481, intent, 134217728));
                alarmManager.setRepeating(0, timeInMillis2, 86400000, PendingIntent.getService(context, 20482, intent, 134217728));
                alarmManager.setRepeating(0, timeInMillis3, 86400000, PendingIntent.getService(context, 20483, intent, 134217728));
                alarmManager.setRepeating(0, timeInMillis4, 86400000, PendingIntent.getService(context, 20484, intent, 134217728));
                alarmManager.setRepeating(0, timeInMillis5, 86400000, PendingIntent.getService(context, 20485, intent, 134217728));
                x.i("MicroMsg.Sport.SportAlarmLogic", "start sport alarm %s %s %s %s %s", new Object[]{n.bx(timeInMillis), n.bx(timeInMillis2), n.bx(timeInMillis3), n.bx(timeInMillis4), n.bx(timeInMillis5)});
                return;
            } catch (Throwable e) {
                x.printErrStackTrace("MicroMsg.Sport.SportAlarmLogic", e, "startSportAlarm", new Object[0]);
                return;
            }
        }
        Context context2 = ad.getContext();
        x.i("MicroMsg.Sport.SportAlarmLogic", "stop sport alarm");
        Intent intent2 = new Intent(context2, SportService.class);
        try {
            PendingIntent service = PendingIntent.getService(context2, 20481, intent2, 134217728);
            if (service != null) {
                service.cancel();
            }
            service = PendingIntent.getService(context2, 20482, intent2, 134217728);
            if (service != null) {
                service.cancel();
            }
            service = PendingIntent.getService(context2, 20483, intent2, 134217728);
            if (service != null) {
                service.cancel();
            }
            service = PendingIntent.getService(context2, 20484, intent2, 134217728);
            if (service != null) {
                service.cancel();
            }
            PendingIntent service2 = PendingIntent.getService(context2, 20485, intent2, 134217728);
            if (service2 != null) {
                service2.cancel();
            }
        } catch (Throwable e2) {
            x.printErrStackTrace("MicroMsg.Sport.SportAlarmLogic", e2, "stopSportAlarm", new Object[0]);
        }
    }
}
