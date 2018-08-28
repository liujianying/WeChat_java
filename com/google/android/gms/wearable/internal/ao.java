package com.google.android.gms.wearable.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.c.e;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.k;
import com.google.android.gms.wearable.b;
import com.google.android.gms.wearable.c;
import com.google.android.gms.wearable.n;
import com.google.android.gms.wearable.q;
import com.google.android.gms.wearable.r.a;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ao extends k<x> {
    final ExecutorService beU = Executors.newCachedThreadPool();
    private final y<a> beV = new y();
    private final y<q.a> beW = new y();
    private final y<b.a> beX = new y();
    private final y<c.b> beY = new y();
    private final y<com.google.android.gms.wearable.k.a> beZ = new y();
    private final y<n.b> bfa = new y();
    private final y<n.c> bfb = new y();
    private final Map<String, y<com.google.android.gms.wearable.a.a>> bfc = new HashMap();

    public ao(Context context, Looper looper, com.google.android.gms.common.api.c.b bVar, com.google.android.gms.common.api.c.c cVar, h hVar) {
        super(context, looper, 14, hVar, bVar, cVar);
    }

    protected final void a(int i, IBinder iBinder, Bundle bundle, int i2) {
        Log.isLoggable("WearableClient", 2);
        if (i == 0) {
            this.beV.u(iBinder);
            this.beW.u(iBinder);
            this.beY.u(iBinder);
            this.beZ.u(iBinder);
            this.bfa.u(iBinder);
            this.bfb.u(iBinder);
            synchronized (this.bfc) {
                for (y u : this.bfc.values()) {
                    u.u(iBinder);
                }
            }
        }
        super.a(i, iBinder, bundle, i2);
    }

    public final void a(e eVar) {
        int i = 7887000;
        if (!ov()) {
            try {
                Bundle bundle = this.mContext.getPackageManager().getApplicationInfo("com.google.android.wearable.app.cn", 128).metaData;
                if (bundle != null) {
                    i = bundle.getInt("com.google.android.wearable.api.version", 7887000);
                }
                if (i < com.google.android.gms.common.b.aJF) {
                    new StringBuilder("Android Wear out of date. Requires API version ").append(com.google.android.gms.common.b.aJF).append(" but found ").append(i);
                    Context context = this.mContext;
                    Context context2 = this.mContext;
                    Intent intent = new Intent("com.google.android.wearable.app.cn.UPDATE_ANDROID_WEAR").setPackage("com.google.android.wearable.app.cn");
                    if (context2.getPackageManager().resolveActivity(intent, 65536) == null) {
                        intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details").buildUpon().appendQueryParameter("id", "com.google.android.wearable.app.cn").build());
                    }
                    a(eVar, new ConnectionResult(6, PendingIntent.getActivity(context, 0, intent, 0)));
                    return;
                }
            } catch (NameNotFoundException e) {
                a(eVar, new ConnectionResult(16, null));
                return;
            }
        }
        super.a(eVar);
    }

    public final void disconnect() {
        this.beV.a(this);
        this.beW.a(this);
        this.beY.a(this);
        this.beZ.a(this);
        this.bfa.a(this);
        this.bfb.a(this);
        synchronized (this.bfc) {
            for (y a : this.bfc.values()) {
                a.a(this);
            }
        }
        super.disconnect();
    }

    protected final /* synthetic */ IInterface f(IBinder iBinder) {
        return x.a.t(iBinder);
    }

    public final boolean ov() {
        com.google.android.gms.common.k.pM();
        return !com.google.android.gms.common.k.a(this.mContext.getPackageManager(), "com.google.android.wearable.app.cn");
    }

    protected final String ow() {
        return "com.google.android.gms.wearable.BIND";
    }

    protected final String ox() {
        return "com.google.android.gms.wearable.internal.IWearableService";
    }

    protected final String pd() {
        com.google.android.gms.common.k.pM();
        return com.google.android.gms.common.k.a(this.mContext.getPackageManager(), "com.google.android.wearable.app.cn") ? "com.google.android.wearable.app.cn" : "com.google.android.gms";
    }
}
