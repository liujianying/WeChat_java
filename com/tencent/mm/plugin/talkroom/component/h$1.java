package com.tencent.mm.plugin.talkroom.component;

import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.x;

class h$1 implements Runnable {
    final /* synthetic */ PInt ovQ;
    final /* synthetic */ PInt ovR;
    final /* synthetic */ boolean ovS;
    final /* synthetic */ h ovT;

    h$1(h hVar, PInt pInt, PInt pInt2, boolean z) {
        this.ovT = hVar;
        this.ovQ = pInt;
        this.ovR = pInt2;
        this.ovS = z;
    }

    public final void run() {
        h.a(this.ovT, true);
        try {
            h.a(this.ovT).k(this.ovQ.value, this.ovR.value, this.ovS);
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.TalkRoomPlayer", e, "", new Object[0]);
        }
        h.a(this.ovT, false);
    }
}
