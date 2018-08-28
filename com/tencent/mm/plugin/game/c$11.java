package com.tencent.mm.plugin.game;

import com.tencent.mm.g.a.gn;
import com.tencent.mm.plugin.game.model.m;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class c$11 extends c<gn> {
    final /* synthetic */ c jFM;

    c$11(c cVar) {
        this.jFM = cVar;
        this.sFo = gn.class.getName().hashCode();
    }

    public final /* bridge */ /* synthetic */ boolean a(b bVar) {
        gn gnVar = (gn) bVar;
        m.a(gnVar.bPI.url, gnVar.bPI.bKg, gnVar.bPI.scene != 0 ? gnVar.bPI.scene : 1000, gnVar.bPI.appId, gnVar.bPI.extInfo);
        return false;
    }
}
