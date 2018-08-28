package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.g.a.lc;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.i;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;

class af$30 extends c<lc> {
    final /* synthetic */ af nqT;

    af$30(af afVar) {
        this.nqT = afVar;
        this.sFo = lc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        lc lcVar = (lc) bVar;
        lcVar.bVr.bVv = lcVar.bVq.source == 1 ? i.bAE().k(lcVar.bVq.bVs, lcVar.bVq.bJv, lcVar.bVq.bVt, lcVar.bVq.bVu) : i.bAE().h(bi.WV(lcVar.bVq.bVs), lcVar.bVq.bVt, lcVar.bVq.bVu);
        return false;
    }
}
