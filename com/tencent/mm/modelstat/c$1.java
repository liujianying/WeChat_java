package com.tencent.mm.modelstat;

import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.sdk.platformtools.x;

class c$1 implements a {
    final /* synthetic */ c eiu;

    c$1(c cVar) {
        this.eiu = cVar;
    }

    public final boolean vD() {
        x.d("MicroMsg.ClickFlowStatReceiver", "monitorHandler ScreenOn:%s isTop:%s top:%s ", new Object[]{Boolean.valueOf(l.fs(ad.getContext())), Boolean.valueOf(!bi.oW(c.bR(ad.getContext()))), c.bR(ad.getContext())});
        if (l.fs(ad.getContext()) && r0) {
            return true;
        }
        c.b(this.eiu).post(new 1(this));
        return false;
    }
}
