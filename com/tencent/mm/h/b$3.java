package com.tencent.mm.h;

import com.tencent.mm.g.a.ry;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.x;

class b$3 implements Runnable {
    final /* synthetic */ b cZR;
    final /* synthetic */ ry cZT;

    b$3(b bVar, ry ryVar) {
        this.cZR = bVar;
        this.cZT = ryVar;
    }

    public final void run() {
        x.i("MicroMsg.BroadcastController", "summerdiz handleEventOOB publish uiEvent");
        a.sFg.m(this.cZT);
    }
}
