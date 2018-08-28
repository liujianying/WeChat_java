package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.expt.roomexpt.d;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class k$4 implements Runnable {
    final /* synthetic */ k tPo;
    final /* synthetic */ String tPp;

    k$4(k kVar, String str) {
        this.tPo = kVar;
        this.tPp = str;
    }

    public final void run() {
        boolean z = false;
        if (!bi.oW(this.tPp)) {
            k.a(this.tPo, t.M(this.tPp, s.dAN));
            x.i("MicroMsg.ChattingUI.ChattingReportComponent", "dkchatmsg:name:%s unRead:%s entryTime:%s(%s)", new Object[]{this.tPp, Integer.valueOf(k.a(this.tPo)), bi.ga(k.b(this.tPo)), Long.valueOf(k.b(this.tPo))});
            if (s.fq(this.tPo.bAG.getTalkerUserName()) && this.tPo.bAG.oLT.csI == 0) {
                z = true;
            }
            ((d) g.l(d.class)).ap(this.tPp, z);
        }
    }
}
