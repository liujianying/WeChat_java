package com.tencent.mm.ipcinvoker;

import com.tencent.mm.ipcinvoker.b.a;
import com.tencent.mm.ipcinvoker.h.b;

class b$2 implements Runnable {
    final /* synthetic */ a dmo;
    final /* synthetic */ String dmp;
    final /* synthetic */ b dmq;

    b$2(b bVar, a aVar, String str) {
        this.dmq = bVar;
        this.dmo = aVar;
        this.dmp = str;
    }

    public final void run() {
        b.i("IPC.IPCBridgeManager", "on connect timeout(%s, tid : %s)", new Object[]{Integer.valueOf(this.dmo.hashCode()), Long.valueOf(Thread.currentThread().getId())});
        if (this.dmo.dmu) {
            synchronized (this.dmo) {
                if (this.dmo.dmu) {
                    this.dmo.dmu = false;
                    this.dmo.notifyAll();
                    this.dmo.dmv = null;
                    synchronized (b.a(this.dmq)) {
                        b.a(this.dmq).remove(this.dmp);
                    }
                    return;
                }
            }
        }
    }
}
