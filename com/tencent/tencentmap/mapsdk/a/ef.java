package com.tencent.tencentmap.mapsdk.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;

final class ef {
    private static ef a = null;
    private ej b;
    private final BroadcastReceiver c = new eg(this);
    private final BroadcastReceiver d = new ei(this);

    ef() {
    }

    public static synchronized ef a() {
        ef efVar;
        synchronized (ef.class) {
            if (a == null) {
                a = new ef();
            }
            efVar = a;
        }
        return efVar;
    }

    public final void a(NetworkInfo networkInfo) {
        if (networkInfo != null) {
            String str = fw.b;
            fw.b();
            String str2 = fw.b;
            if (!str.equals(str2)) {
                if (str.equals(fw.a) && fw.e()) {
                    fx.b("AccessSchedulerTrigger", "open network：apn2：" + str2);
                    if (this.b != null) {
                        this.b.b();
                    } else {
                        fx.c("AccessSchedulerTrigger", "onAccessSchedulerTriggered not call for triggerlistener is null");
                    }
                } else if (str2.equals(fw.a) || !fw.e()) {
                    fx.b("AccessSchedulerTrigger", "close network");
                } else {
                    fx.b("AccessSchedulerTrigger", "onTrigger：  apn1：" + str + " ,apn2：" + str2);
                    if (this.b != null) {
                        this.b.b();
                    } else {
                        fx.c("AccessSchedulerTrigger", "onAccessSchedulerTriggered not call for triggerlistener is null");
                    }
                }
            }
        }
    }

    public final void a(ej ejVar) {
        this.b = ejVar;
        em.a().registerReceiver(this.c, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        fx.b("AccessSchedulerTrigger", "startListenNetworkChange...");
        fx.b("AccessSchedulerTrigger", "try startAccessSchedulerTimer...");
        em.a().registerReceiver(this.d, new IntentFilter("action.scheduler.access.trigger.timer"));
        AlarmManager alarmManager = (AlarmManager) em.a().getSystemService("alarm");
        if (alarmManager != null) {
            alarmManager.setRepeating(3, System.currentTimeMillis() + 1200000, 1200000, PendingIntent.getBroadcast(em.a(), 0, new Intent("action.scheduler.access.trigger.timer"), 0));
            fx.a("AccessSchedulerTrigger", "startAccessSchedulerTimer timer start...");
        }
    }

    public final void b() {
        if (this.b != null) {
            this.b.b();
        } else {
            fx.c("AccessSchedulerTrigger", "onAccessSchedulerTriggered not call for triggerlistener is null");
        }
    }
}
