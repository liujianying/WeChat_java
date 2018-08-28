package com.tencent.mm.plugin.sns.e;

import com.tencent.mm.g.a.qb;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.an;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class a implements b {
    public c nll = new 1(this);

    public a() {
        com.tencent.mm.sdk.b.a.sFg.b(this.nll);
        af.byj().a((b) this);
    }

    public final void LR(String str) {
        x.i("MicroMsg.FTS.FTSSnsImageDownloadLogic", "onThumbFinish mediaId=%s", new Object[]{str});
        qb qbVar = new qb();
        qbVar.caJ.bIH = 2;
        qbVar.caJ.mediaId = str;
        String s = an.s(af.getAccSnsPath(), str);
        qbVar.caJ.path = s + i.LA(str);
        com.tencent.mm.sdk.b.a.sFg.m(qbVar);
    }

    public final void aS(String str, boolean z) {
    }

    public final void bxb() {
    }

    public final void aT(String str, boolean z) {
    }
}
