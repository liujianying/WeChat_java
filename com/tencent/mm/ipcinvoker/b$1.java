package com.tencent.mm.ipcinvoker;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.tencent.mm.ipcinvoker.b.a;
import com.tencent.mm.ipcinvoker.h.b;

class b$1 implements ServiceConnection {
    final /* synthetic */ a dmo;
    final /* synthetic */ String dmp;
    final /* synthetic */ b dmq;
    final /* synthetic */ Context val$context;

    b$1(b bVar, a aVar, Context context, String str) {
        this.dmq = bVar;
        this.dmo = aVar;
        this.val$context = context;
        this.dmp = str;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            b.i("IPC.IPCBridgeManager", "onServiceConnected(%s), but service is null", Integer.valueOf(this.dmo.hashCode()));
            this.val$context.unbindService(this.dmo.dmt);
            b.a(this.dmq).remove(this.dmp);
            this.dmo.dmt = null;
            this.dmo.dms = null;
        } else {
            b.i("IPC.IPCBridgeManager", "onServiceConnected(%s)", Integer.valueOf(this.dmo.hashCode()));
            this.dmo.dms = com.tencent.mm.ipcinvoker.b.a.a.z(iBinder);
            try {
                iBinder.linkToDeath(new com.tencent.mm.ipcinvoker.f.a(this.dmp), 0);
            } catch (Throwable e) {
                b.e("IPC.IPCBridgeManager", "binder register linkToDeath listener error, %s", Log.getStackTraceString(e));
            }
        }
        if (this.dmo.dmv != null) {
            b.b(this.dmq).removeCallbacks(this.dmo.dmv);
        }
        synchronized (this.dmo) {
            this.dmo.dmu = false;
            this.dmo.notifyAll();
            this.dmo.dmv = null;
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        b.i("IPC.IPCBridgeManager", "onServiceDisconnected(%s, tid : %s)", Integer.valueOf(this.dmo.hashCode()), Long.valueOf(Thread.currentThread().getId()));
        this.dmq.fB(this.dmp);
        com.tencent.mm.ipcinvoker.f.b.fI(this.dmp);
    }
}
