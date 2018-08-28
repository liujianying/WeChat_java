package com.tencent.mm.plugin.game;

import com.tencent.mm.g.a.nj;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;

class c$16 extends c<nj> {
    final /* synthetic */ c jFM;

    c$16(c cVar) {
        this.jFM = cVar;
        this.sFo = nj.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        nj njVar = (nj) bVar;
        an.a(ad.getContext(), njVar.bYp.scene, njVar.bYp.bYq, 1, njVar.bYp.action, 0, njVar.bYp.appId, 0, njVar.bYp.msgType, njVar.bYp.bWQ, njVar.bYp.bHF, njVar.bYp.bYr);
        return false;
    }
}
