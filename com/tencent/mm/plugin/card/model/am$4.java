package com.tencent.mm.plugin.card.model;

import com.tencent.mm.g.a.nz;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

class am$4 extends c<nz> {
    final /* synthetic */ am hxV;

    am$4(am amVar) {
        this.hxV = amVar;
        this.sFo = nz.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x.i("MicroMsg.SubCoreCard.ResetCardRetryCounter", "deal with reset card retry counter event");
        al axj = am.axj();
        x.d("MicroMsg.PendingCardIdInfoStorage", "resetRetryCounter");
        axj.diF.fV("PendingCardId", "update PendingCardId set retryCount = 0 where retryCount >= 10");
        return false;
    }
}
