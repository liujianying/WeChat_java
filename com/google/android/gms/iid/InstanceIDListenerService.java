package com.google.android.gms.iid;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.gcm.GcmReceiver;
import com.google.android.gms.gcm.a;
import java.io.IOException;

public class InstanceIDListenerService extends Service {
    static String ACTION = "action";
    private static String aQw = "gcm.googleapis.com/refresh";
    private static String aRa = "google.com/iid";
    private static String aRb = "CMD";
    MessengerCompat aQY = new MessengerCompat(new 1(this, Looper.getMainLooper()));
    BroadcastReceiver aQZ = new 2(this);
    int aRc;
    int aRd;

    static void a(Context context, e eVar) {
        eVar.pS();
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.putExtra(aRb, "RST");
        intent.setPackage(context.getPackageName());
        context.startService(intent);
    }

    static /* synthetic */ void a(InstanceIDListenerService instanceIDListenerService, Message message, int i) {
        d.aq(instanceIDListenerService);
        instanceIDListenerService.getPackageManager();
        if (i == d.aRk || i == d.aRj) {
            instanceIDListenerService.e((Intent) message.obj);
        } else {
            new StringBuilder("Message from unexpected caller ").append(i).append(" mine=").append(d.aRj).append(" appid=").append(d.aRk);
        }
    }

    static void ap(Context context) {
        Intent intent = new Intent("com.google.android.gms.iid.InstanceID");
        intent.setPackage(context.getPackageName());
        intent.putExtra(aRb, "SYNC");
        context.startService(intent);
    }

    public final void e(Intent intent) {
        a ao;
        String stringExtra = intent.getStringExtra("subtype");
        if (stringExtra == null) {
            ao = a.ao(this);
        } else {
            Bundle bundle = new Bundle();
            bundle.putString("subtype", stringExtra);
            ao = a.c(this, bundle);
        }
        String stringExtra2 = intent.getStringExtra(aRb);
        if (intent.getStringExtra("error") == null && intent.getStringExtra("registration_id") == null) {
            if (Log.isLoggable("InstanceID", 3)) {
                new StringBuilder("Service command ").append(stringExtra).append(" ").append(stringExtra2).append(" ").append(intent.getExtras());
            }
            if (intent.getStringExtra("unregistered") != null) {
                a.pN().bo(stringExtra == null ? "" : stringExtra);
                a.pO().h(intent);
                return;
            } else if (aQw.equals(intent.getStringExtra("from"))) {
                a.pN().bo(stringExtra);
                return;
            } else if ("RST".equals(stringExtra2)) {
                ao.aQW = 0;
                a.aQS.bn(ao.aQV + "|");
                ao.aQU = null;
                return;
            } else if ("RST_FULL".equals(stringExtra2)) {
                if (!a.pN().isEmpty()) {
                    a.pN().pS();
                    return;
                }
                return;
            } else if ("SYNC".equals(stringExtra2)) {
                a.pN().bo(stringExtra);
                return;
            } else if ("PING".equals(stringExtra2)) {
                try {
                    a.al(this).a(aRa, d.pR(), intent.getExtras());
                    return;
                } catch (IOException e) {
                    return;
                }
            } else {
                return;
            }
        }
        Log.isLoggable("InstanceID", 3);
        a.pO().h(intent);
    }

    public IBinder onBind(Intent intent) {
        return (intent == null || !"com.google.android.gms.iid.InstanceID".equals(intent.getAction())) ? null : this.aQY.getBinder();
    }

    public void onCreate() {
        IntentFilter intentFilter = new IntentFilter("com.google.android.c2dm.intent.REGISTRATION");
        intentFilter.addCategory(getPackageName());
        registerReceiver(this.aQZ, intentFilter, "com.google.android.c2dm.permission.RECEIVE", null);
    }

    public void onDestroy() {
        unregisterReceiver(this.aQZ);
    }

    public int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this) {
            this.aRc++;
            if (i2 > this.aRd) {
                this.aRd = i2;
            }
        }
        if (intent == null) {
            stop();
            return 2;
        }
        try {
            if ("com.google.android.gms.iid.InstanceID".equals(intent.getAction())) {
                if (VERSION.SDK_INT <= 18) {
                    Intent intent2 = (Intent) intent.getParcelableExtra("GSF");
                    if (intent2 != null) {
                        startService(intent2);
                        return 1;
                    }
                }
                e(intent);
            }
            stop();
            if (intent.getStringExtra("from") != null) {
                GcmReceiver.b(intent);
            }
            return 2;
        } finally {
            stop();
        }
    }

    final void stop() {
        synchronized (this) {
            this.aRc--;
            if (this.aRc == 0) {
                stopSelf(this.aRd);
            }
            if (Log.isLoggable("InstanceID", 3)) {
                new StringBuilder("Stop ").append(this.aRc).append(" ").append(this.aRd);
            }
        }
    }
}
