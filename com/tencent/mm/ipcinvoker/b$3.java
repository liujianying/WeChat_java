package com.tencent.mm.ipcinvoker;

import android.content.ServiceConnection;
import android.util.Log;
import com.tencent.mm.ipcinvoker.b.a;
import com.tencent.mm.ipcinvoker.h.b;

class b$3 implements Runnable {
    final /* synthetic */ String dmp;
    final /* synthetic */ b dmq;
    final /* synthetic */ a dmr;

    b$3(b bVar, a aVar, String str) {
        this.dmq = bVar;
        this.dmr = aVar;
        this.dmp = str;
    }

    public final void run() {
        ServiceConnection serviceConnection = this.dmr.dmt;
        if (serviceConnection == null) {
            b.i("IPC.IPCBridgeManager", "releaseIPCBridge(%s) failed, ServiceConnection is null.", new Object[]{this.dmp});
            return;
        }
        try {
            e.getContext().unbindService(serviceConnection);
        } catch (Throwable e) {
            b.e("IPC.IPCBridgeManager", "unbindService(%s) error, %s", new Object[]{this.dmp, Log.getStackTraceString(e)});
        }
        synchronized (b.a(this.dmq)) {
            b.a(this.dmq).remove(this.dmp);
        }
        synchronized (this.dmr) {
            this.dmr.dms = null;
            this.dmr.dmu = false;
            this.dmr.dmt = null;
        }
    }
}
