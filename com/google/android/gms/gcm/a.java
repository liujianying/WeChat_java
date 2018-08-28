package com.google.android.gms.gcm;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import com.google.android.gms.iid.d;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class a {
    public static int aQA = 7000000;
    static a aQB;
    private static final AtomicInteger aQE = new AtomicInteger(1);
    public static int aQy = 5000000;
    public static int aQz = 6500000;
    private PendingIntent aQC;
    private Map<String, Handler> aQD = Collections.synchronizedMap(new HashMap());
    private final BlockingQueue<Intent> aQF = new LinkedBlockingQueue();
    final Messenger aQG = new Messenger(new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            if (message != null) {
                Object obj = message.obj;
            }
            Intent intent = (Intent) message.obj;
            if ("com.google.android.c2dm.intent.REGISTRATION".equals(intent.getAction())) {
                a.this.aQF.add(intent);
            } else if (!a.a(a.this, intent)) {
                intent.setPackage(a.this.context.getPackageName());
                a.this.context.sendBroadcast(intent);
            }
        }
    });
    private Context context;

    static /* synthetic */ boolean a(a aVar, Intent intent) {
        Object stringExtra = intent.getStringExtra("In-Reply-To");
        if (stringExtra == null && intent.hasExtra("error")) {
            stringExtra = intent.getStringExtra("google.message_id");
        }
        if (stringExtra != null) {
            Handler handler = (Handler) aVar.aQD.remove(stringExtra);
            if (handler != null) {
                Message obtain = Message.obtain();
                obtain.obj = intent;
                return handler.sendMessage(obtain);
            }
        }
        return false;
    }

    public static synchronized a al(Context context) {
        a aVar;
        synchronized (a.class) {
            if (aQB == null) {
                aVar = new a();
                aQB = aVar;
                aVar.context = context.getApplicationContext();
            }
            aVar = aQB;
        }
        return aVar;
    }

    public static int am(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(d.aq(context), 0).versionCode;
        } catch (NameNotFoundException e) {
            return -1;
        }
    }

    public static String c(Intent intent) {
        if (!"com.google.android.c2dm.intent.RECEIVE".equals(intent.getAction())) {
            return null;
        }
        String stringExtra = intent.getStringExtra("message_type");
        return stringExtra == null ? "gcm" : stringExtra;
    }

    private synchronized void d(Intent intent) {
        if (this.aQC == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.aQC = PendingIntent.getBroadcast(this.context, 0, intent2, 0);
        }
        intent.putExtra("app", this.aQC);
    }

    @Deprecated
    private Intent g(Bundle bundle) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            throw new IOException("MAIN_THREAD");
        } else if (am(this.context) < 0) {
            throw new IOException("Google Play Services missing");
        } else {
            Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent.setPackage(d.aq(this.context));
            d(intent);
            intent.putExtra("google.message_id", "google.rpc" + String.valueOf(aQE.getAndIncrement()));
            intent.putExtras(bundle);
            intent.putExtra("google.messenger", this.aQG);
            this.context.startService(intent);
            try {
                return (Intent) this.aQF.poll(30000, TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                throw new IOException(e.getMessage());
            }
        }
    }

    public final void a(String str, String str2, Bundle bundle) {
        if (str == null) {
            throw new IllegalArgumentException("Missing 'to'");
        }
        Intent intent = new Intent("com.google.android.gcm.intent.SEND");
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        d(intent);
        intent.setPackage(d.aq(this.context));
        intent.putExtra("google.to", str);
        intent.putExtra("google.message_id", str2);
        intent.putExtra("google.ttl", Long.toString(0));
        intent.putExtra("google.delay", Integer.toString(-1));
        if (d.aq(this.context).contains(".gsf")) {
            Bundle bundle2 = new Bundle();
            for (String str3 : bundle.keySet()) {
                Object obj = bundle.get(str3);
                if (obj instanceof String) {
                    bundle2.putString("gcm." + str3, (String) obj);
                }
            }
            bundle2.putString("google.to", str);
            bundle2.putString("google.message_id", str2);
            com.google.android.gms.iid.a.ao(this.context).b("GCM", "upstream", bundle2);
            return;
        }
        this.context.sendOrderedBroadcast(intent, "com.google.android.gtalkservice.permission.GTALK_SERVICE");
    }

    @Deprecated
    public final synchronized String c(String... strArr) {
        String e;
        Object obj = null;
        synchronized (this) {
            String stringBuilder = new StringBuilder(strArr[0]).toString();
            Bundle bundle = new Bundle();
            if (d.aq(this.context).contains(".gsf")) {
                bundle.putString("legacy.sender", stringBuilder);
                com.google.android.gms.iid.a ao = com.google.android.gms.iid.a.ao(this.context);
                String str = "GCM";
                if (Looper.getMainLooper() == Looper.myLooper()) {
                    throw new IOException("MAIN_THREAD");
                }
                Object obj2 = 1;
                e = com.google.android.gms.iid.a.pP() ? null : com.google.android.gms.iid.a.aQS.e(ao.aQV, stringBuilder, str);
                if (e == null) {
                    if (bundle.getString("ttl") != null) {
                        obj2 = null;
                    }
                    if (!"jwt".equals(bundle.getString("type"))) {
                        obj = obj2;
                    }
                    e = ao.b(stringBuilder, str, bundle);
                    if (!(e == null || obj == null)) {
                        com.google.android.gms.iid.a.aQS.b(ao.aQV, stringBuilder, str, e, com.google.android.gms.iid.a.aQX);
                    }
                }
            } else {
                bundle.putString("sender", stringBuilder);
                Intent g = g(bundle);
                String str2 = "registration_id";
                if (g == null) {
                    throw new IOException("SERVICE_NOT_AVAILABLE");
                }
                e = g.getStringExtra(str2);
                if (e == null) {
                    String stringExtra = g.getStringExtra("error");
                    if (stringExtra != null) {
                        throw new IOException(stringExtra);
                    }
                    throw new IOException("SERVICE_NOT_AVAILABLE");
                }
            }
        }
        return e;
    }
}
