package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.talkroom.b.e;
import com.tencent.mm.sdk.platformtools.ab.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class g$5 implements a {
    final /* synthetic */ g oxj;

    g$5(g gVar) {
        this.oxj = gVar;
    }

    public final boolean vD() {
        if (g.e(this.oxj) == 0 || bi.oW(g.g(this.oxj))) {
            x.w("MicroMsg.TalkRoomServer", "talkNoopTimer error: roomId %d, talkUsername %s", new Object[]{Integer.valueOf(g.e(this.oxj)), g.g(this.oxj)});
            g.h(this.oxj);
            return false;
        }
        String g = g.g(this.oxj);
        int e = g.e(this.oxj);
        long f = g.f(this.oxj);
        g gVar = this.oxj;
        g.g(this.oxj);
        au.DF().a(new e(g, e, f, gVar.bHb()), 0);
        return true;
    }
}
