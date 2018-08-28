package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.memory.c;
import com.tencent.mm.memory.e.a;
import com.tencent.mm.sdk.platformtools.ad;

class af$8 extends a {
    final /* synthetic */ af nqT;
    final int nqU = 120;

    af$8(af afVar, c cVar) {
        this.nqT = afVar;
        cVar.getClass();
        super(cVar);
    }

    public final /* synthetic */ Comparable Fp() {
        return Integer.valueOf(com.tencent.mm.bp.a.fromDPToPix(ad.getContext(), 120) * com.tencent.mm.bp.a.fromDPToPix(ad.getContext(), 120));
    }

    public final long Fq() {
        return 10485760;
    }

    public final int Fr() {
        return -1;
    }
}
