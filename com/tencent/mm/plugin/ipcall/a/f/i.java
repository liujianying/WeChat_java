package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.a.b;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.d.o;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends b {
    private o kst = null;
    private int ksu = 0;

    public final int[] aXB() {
        return new int[]{819};
    }

    public final void onStop() {
        if (this.kst != null) {
            au.DF().c(this.kst);
        }
    }

    public final int Mw() {
        return 2;
    }

    public final void aXC() {
    }

    public final void onDestroy() {
    }

    public final void b(c cVar) {
        boolean z = true;
        String str = "MicroMsg.IPCallSyncService";
        String str2 = "serviceImpl, info==null: %b";
        Object[] objArr = new Object[1];
        if (cVar != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        x.d(str, str2, objArr);
        if (this.koG != null) {
            this.ksu = this.koG.kpy;
            this.kst = new o(this.koG.kpo, this.koG.kpp, this.koG.aXG(), this.koG.kpq, false);
            au.DF().a(this.kst, 0);
        }
    }

    public final int aXD() {
        return this.ksu;
    }

    public final void aXE() {
        x.d("MicroMsg.IPCallSyncService", "onLoopSuccess");
    }

    public final void aXF() {
        x.d("MicroMsg.IPCallSyncService", "onLoopFailed");
    }
}
