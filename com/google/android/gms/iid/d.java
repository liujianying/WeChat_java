package com.google.android.gms.iid;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ConditionVariable;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Process;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.gcm.a;
import com.tencent.smtt.utils.TbsLog;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public final class d {
    static String aRi = null;
    static int aRj = 0;
    static int aRk = 0;
    static int aRl = 0;
    PendingIntent aQC;
    Messenger aQG;
    Map<String, Object> aRm = new HashMap();
    Messenger aRn;
    MessengerCompat aRo;
    long aRp;
    long aRq;
    int aRr;
    int aRs;
    long aRt;
    Context context;

    public d(Context context) {
        this.context = context;
    }

    private static String a(KeyPair keyPair, String... strArr) {
        try {
            byte[] bytes = TextUtils.join("\n", strArr).getBytes("UTF-8");
            try {
                PrivateKey privateKey = keyPair.getPrivate();
                Signature instance = Signature.getInstance(privateKey instanceof RSAPrivateKey ? "SHA256withRSA" : "SHA256withECDSA");
                instance.initSign(privateKey);
                instance.update(bytes);
                return a.j(instance.sign());
            } catch (GeneralSecurityException e) {
                return null;
            }
        } catch (UnsupportedEncodingException e2) {
            return null;
        }
    }

    private void aj(Object obj) {
        synchronized (getClass()) {
            for (String str : this.aRm.keySet()) {
                Object obj2 = this.aRm.get(str);
                this.aRm.put(str, obj);
                k(obj2, obj);
            }
        }
    }

    public static String aq(Context context) {
        if (aRi != null) {
            return aRi;
        }
        aRj = Process.myUid();
        PackageManager packageManager = context.getPackageManager();
        for (ResolveInfo resolveInfo : packageManager.queryIntentServices(new Intent("com.google.android.c2dm.intent.REGISTER"), 0)) {
            if (packageManager.checkPermission("com.google.android.c2dm.permission.RECEIVE", resolveInfo.serviceInfo.packageName) == 0) {
                try {
                    ApplicationInfo applicationInfo = packageManager.getApplicationInfo(resolveInfo.serviceInfo.packageName, 0);
                    new StringBuilder("Found ").append(applicationInfo.uid);
                    aRk = applicationInfo.uid;
                    String str = resolveInfo.serviceInfo.packageName;
                    aRi = str;
                    return str;
                } catch (NameNotFoundException e) {
                }
            } else {
                new StringBuilder("Possible malicious package ").append(resolveInfo.serviceInfo.packageName).append(" declares com.google.android.c2dm.intent.REGISTER without permission");
            }
        }
        ApplicationInfo applicationInfo2;
        try {
            applicationInfo2 = packageManager.getApplicationInfo("com.google.android.gms", 0);
            aRi = applicationInfo2.packageName;
            aRk = applicationInfo2.uid;
            return aRi;
        } catch (NameNotFoundException e2) {
            try {
                applicationInfo2 = packageManager.getApplicationInfo("com.google.android.gsf", 0);
                aRi = applicationInfo2.packageName;
                aRk = applicationInfo2.uid;
                return aRi;
            } catch (NameNotFoundException e3) {
                return null;
            }
        }
    }

    private synchronized void f(Intent intent) {
        if (this.aQC == null) {
            Intent intent2 = new Intent();
            intent2.setPackage("com.google.example.invalidpackage");
            this.aQC = PendingIntent.getBroadcast(this.context, 0, intent2, 0);
        }
        intent.putExtra("app", this.aQC);
    }

    static String g(Intent intent) {
        if (intent == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String stringExtra = intent.getStringExtra("registration_id");
        if (stringExtra == null) {
            stringExtra = intent.getStringExtra("unregistered");
        }
        intent.getLongExtra("Retry-After", 0);
        if (stringExtra != null) {
            return stringExtra;
        }
        stringExtra = intent.getStringExtra("error");
        if (stringExtra != null) {
            throw new IOException(stringExtra);
        }
        new StringBuilder("Unexpected response from GCM ").append(intent.getExtras());
        Throwable th = new Throwable();
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    private void j(String str, Object obj) {
        synchronized (getClass()) {
            Object obj2 = this.aRm.get(str);
            this.aRm.put(str, obj);
            k(obj2, obj);
        }
    }

    private static void k(Object obj, Object obj2) {
        if (obj instanceof ConditionVariable) {
            ((ConditionVariable) obj).open();
        }
        if (obj instanceof Messenger) {
            Messenger messenger = (Messenger) obj;
            Message obtain = Message.obtain();
            obtain.obj = obj2;
            try {
                messenger.send(obtain);
            } catch (RemoteException e) {
                new StringBuilder("Failed to send response ").append(e);
            }
        }
    }

    public static synchronized String pR() {
        String num;
        synchronized (d.class) {
            int i = aRl;
            aRl = i + 1;
            num = Integer.toString(i);
        }
        return num;
    }

    final Intent a(Bundle bundle, KeyPair keyPair) {
        ConditionVariable conditionVariable = new ConditionVariable();
        String pR = pR();
        synchronized (getClass()) {
            this.aRm.put(pR, conditionVariable);
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (this.aRt == 0 || elapsedRealtime > this.aRt) {
            if (this.aQG == null) {
                aq(this.context);
                this.aQG = new Messenger(new 1(this, Looper.getMainLooper()));
            }
            if (aRi == null) {
                throw new IOException("MISSING_INSTANCEID_SERVICE");
            }
            Intent intent;
            this.aRp = SystemClock.elapsedRealtime();
            Intent intent2 = new Intent("com.google.android.c2dm.intent.REGISTER");
            intent2.setPackage(aRi);
            bundle.putString("gmsv", Integer.toString(a.am(this.context)));
            bundle.putString("osv", Integer.toString(VERSION.SDK_INT));
            bundle.putString("app_ver", Integer.toString(a.an(this.context)));
            bundle.putString("cliv", "1");
            bundle.putString("appid", a.a(keyPair));
            bundle.putString("pub2", a.j(keyPair.getPublic().getEncoded()));
            bundle.putString("sig", a(keyPair, this.context.getPackageName(), r0));
            intent2.putExtras(bundle);
            f(intent2);
            this.aRp = SystemClock.elapsedRealtime();
            intent2.putExtra("kid", "|ID|" + pR + "|");
            intent2.putExtra("X-kid", "|ID|" + pR + "|");
            boolean equals = "com.google.android.gsf".equals(aRi);
            String stringExtra = intent2.getStringExtra("useGsf");
            if (stringExtra != null) {
                equals = "1".equals(stringExtra);
            }
            if (Log.isLoggable("InstanceID/Rpc", 3)) {
                new StringBuilder("Sending ").append(intent2.getExtras());
            }
            if (this.aRn != null) {
                intent2.putExtra("google.messenger", this.aQG);
                Message obtain = Message.obtain();
                obtain.obj = intent2;
                try {
                    this.aRn.send(obtain);
                } catch (RemoteException e) {
                    Log.isLoggable("InstanceID/Rpc", 3);
                }
                conditionVariable.block(30000);
                synchronized (getClass()) {
                    Object remove = this.aRm.remove(pR);
                    if (remove instanceof Intent) {
                        intent = (Intent) remove;
                    } else if (remove instanceof String) {
                        throw new IOException((String) remove);
                    } else {
                        new StringBuilder("No response ").append(remove);
                        throw new IOException("TIMEOUT");
                    }
                }
                return intent;
            }
            if (equals) {
                intent = new Intent("com.google.android.gms.iid.InstanceID");
                intent.setPackage(this.context.getPackageName());
                intent.putExtra("GSF", intent2);
                this.context.startService(intent);
            } else {
                intent2.putExtra("google.messenger", this.aQG);
                intent2.putExtra("messenger2", "1");
                if (this.aRo != null) {
                    Message obtain2 = Message.obtain();
                    obtain2.obj = intent2;
                    try {
                        MessengerCompat messengerCompat = this.aRo;
                        if (messengerCompat.aRf != null) {
                            messengerCompat.aRf.send(obtain2);
                        } else {
                            messengerCompat.aRg.send(obtain2);
                        }
                    } catch (RemoteException e2) {
                        Log.isLoggable("InstanceID/Rpc", 3);
                    }
                }
                this.context.startService(intent2);
            }
            conditionVariable.block(30000);
            synchronized (getClass()) {
                Object remove2 = this.aRm.remove(pR);
                if (remove2 instanceof Intent) {
                    intent = (Intent) remove2;
                } else if (remove2 instanceof String) {
                    throw new IOException((String) remove2);
                } else {
                    new StringBuilder("No response ").append(remove2);
                    throw new IOException("TIMEOUT");
                }
            }
            return intent;
        }
        new StringBuilder("Backoff mode, next request attempt: ").append(this.aRt - elapsedRealtime).append(" interval: ").append(this.aRs);
        throw new IOException("RETRY_LATER");
    }

    final void h(Intent intent) {
        if (intent == null) {
            Log.isLoggable("InstanceID/Rpc", 3);
            return;
        }
        String action = intent.getAction();
        if ("com.google.android.c2dm.intent.REGISTRATION".equals(action) || "com.google.android.gms.iid.InstanceID".equals(action)) {
            action = intent.getStringExtra("registration_id");
            String stringExtra = action == null ? intent.getStringExtra("unregistered") : action;
            if (stringExtra == null) {
                stringExtra = intent.getStringExtra("error");
                if (stringExtra == null) {
                    new StringBuilder("Unexpected response, no error or registration id ").append(intent.getExtras());
                    return;
                }
                Log.isLoggable("InstanceID/Rpc", 3);
                action = null;
                if (stringExtra.startsWith("|")) {
                    String[] split = stringExtra.split("\\|");
                    "ID".equals(split[1]);
                    if (split.length > 2) {
                        action = split[2];
                        stringExtra = split[3];
                        if (stringExtra.startsWith(":")) {
                            stringExtra = stringExtra.substring(1);
                        }
                    } else {
                        stringExtra = "UNKNOWN";
                    }
                    intent.putExtra("error", stringExtra);
                }
                if (action == null) {
                    aj(stringExtra);
                } else {
                    j(action, stringExtra);
                }
                long longExtra = intent.getLongExtra("Retry-After", 0);
                if (longExtra > 0) {
                    this.aRq = SystemClock.elapsedRealtime();
                    this.aRs = ((int) longExtra) * TbsLog.TBSLOG_CODE_SDK_BASE;
                    this.aRt = SystemClock.elapsedRealtime() + ((long) this.aRs);
                    new StringBuilder("Explicit request from server to backoff: ").append(this.aRs);
                    return;
                } else if (("SERVICE_NOT_AVAILABLE".equals(stringExtra) || "AUTHENTICATION_FAILED".equals(stringExtra)) && "com.google.android.gsf".equals(aRi)) {
                    this.aRr++;
                    if (this.aRr >= 3) {
                        if (this.aRr == 3) {
                            this.aRs = new Random().nextInt(TbsLog.TBSLOG_CODE_SDK_BASE) + TbsLog.TBSLOG_CODE_SDK_BASE;
                        }
                        this.aRs *= 2;
                        this.aRt = SystemClock.elapsedRealtime() + ((long) this.aRs);
                        new StringBuilder("Backoff due to ").append(stringExtra).append(" for ").append(this.aRs);
                        return;
                    }
                    return;
                } else {
                    return;
                }
            }
            this.aRp = SystemClock.elapsedRealtime();
            this.aRt = 0;
            this.aRr = 0;
            this.aRs = 0;
            if (Log.isLoggable("InstanceID/Rpc", 3)) {
                new StringBuilder("AppIDResponse: ").append(stringExtra).append(" ").append(intent.getExtras());
            }
            action = null;
            if (stringExtra.startsWith("|")) {
                String[] split2 = stringExtra.split("\\|");
                "ID".equals(split2[1]);
                stringExtra = split2[2];
                if (split2.length > 4) {
                    if ("SYNC".equals(split2[3])) {
                        InstanceIDListenerService.ap(this.context);
                    } else if ("RST".equals(split2[3])) {
                        Context context = this.context;
                        a.ao(this.context);
                        InstanceIDListenerService.a(context, a.pN());
                        intent.removeExtra("registration_id");
                        j(stringExtra, intent);
                        return;
                    }
                }
                action = split2[split2.length - 1];
                if (action.startsWith(":")) {
                    action = action.substring(1);
                }
                intent.putExtra("registration_id", action);
                action = stringExtra;
            }
            if (action == null) {
                aj(intent);
            } else {
                j(action, intent);
            }
        } else if (Log.isLoggable("InstanceID/Rpc", 3)) {
            new StringBuilder("Unexpected response ").append(intent.getAction());
        }
    }
}
