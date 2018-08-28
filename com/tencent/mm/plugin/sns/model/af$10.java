package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.memory.e.a;
import com.tencent.mm.memory.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;

class af$10 extends a {
    final /* synthetic */ af nqT;

    af$10(af afVar, g gVar) {
        this.nqT = afVar;
        gVar.getClass();
        super(gVar);
    }

    public final /* synthetic */ Comparable Fp() {
        return Integer.valueOf(WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
    }

    public final long Fq() {
        return 0;
    }

    public final int Fr() {
        return 5;
    }
}
