package com.tencent.mm.ipcinvoker;

import android.os.Parcelable;
import android.os.RemoteException;
import com.tencent.mm.ipcinvoker.b.a;
import com.tencent.mm.ipcinvoker.h.b;

class f$1 implements Runnable {
    final /* synthetic */ Class dmC;
    final /* synthetic */ Parcelable dmD;
    final /* synthetic */ String dmp;
    final /* synthetic */ c dmx;

    f$1(String str, Class cls, Parcelable parcelable, c cVar) {
        this.dmp = str;
        this.dmC = cls;
        this.dmD = parcelable;
        this.dmx = cVar;
    }

    public final void run() {
        if (e.fC(this.dmp)) {
            a aVar = (a) j.a(this.dmC, a.class);
            if (aVar == null) {
                b.e("IPC.IPCInvoker", "invokeAsync failed, newInstance(%s) return null.", new Object[]{this.dmC});
                return;
            }
            aVar.a(this.dmD, this.dmx);
            return;
        }
        a fA = b.Cq().fA(this.dmp);
        if (fA == null) {
            b.e("IPC.IPCInvoker", "invokeAsync failed, get bridge is null by process(%s).", new Object[]{this.dmp});
            return;
        }
        com.tencent.mm.ipcinvoker.b.b bVar = null;
        try {
            if (this.dmx != null) {
                bVar = new f.a(this.dmp, this.dmx);
            }
            fA.a(f.b(this.dmD), this.dmC.getName(), bVar);
        } catch (RemoteException e) {
            b.d("IPC.IPCInvoker", "invokeAsync failed, ipc invoke error : %s", new Object[]{e});
        }
    }
}
