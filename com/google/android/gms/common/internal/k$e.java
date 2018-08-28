package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.common.internal.k.h;
import com.google.android.gms.common.internal.s.a;

public final class k$e implements ServiceConnection {
    final /* synthetic */ k aOj;
    private final int aOm;

    public k$e(k kVar, int i) {
        this.aOj = kVar;
        this.aOm = i;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        w.j(iBinder, "Expecting a valid IBinder");
        k.a(this.aOj, a.i(iBinder));
        k kVar = this.aOj;
        kVar.mHandler.sendMessage(kVar.mHandler.obtainMessage(6, this.aOm, -1, new h(kVar)));
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        this.aOj.mHandler.sendMessage(this.aOj.mHandler.obtainMessage(4, this.aOm, 1));
    }
}
