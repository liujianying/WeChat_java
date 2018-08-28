package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.a.b;
import com.tencent.mm.plugin.ipcall.a.d.h;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends b {
    private h ksp;

    public final int[] aXB() {
        return new int[]{824};
    }

    public final void onStop() {
        if (this.ksp != null) {
            au.DF().c(this.ksp);
        }
    }

    public final int Mw() {
        return 5;
    }

    public final void aXC() {
    }

    public final void onDestroy() {
    }

    public final void b(com.tencent.mm.plugin.ipcall.a.a.c cVar) {
        if (this.koG != null) {
            this.ksp = new h(this.koG.kpo, this.koG.kpp, this.koG.kpq);
            au.DF().a(this.ksp, 0);
        }
    }

    public final int aXD() {
        return 50000;
    }

    public final void aXE() {
        x.d("MicroMsg.IPCallHeartBeatService", "heartbeat, onLoopSuccess");
    }

    public final void aXF() {
        x.d("MicroMsg.IPCallHeartBeatService", "heartbeat, onLoopFailed");
    }
}
