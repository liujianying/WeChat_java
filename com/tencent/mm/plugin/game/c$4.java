package com.tencent.mm.plugin.game;

import com.tencent.mm.g.a.gm;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class c$4 extends c<gm> {
    final /* synthetic */ c jFM;

    c$4(c cVar) {
        this.jFM = cVar;
        this.sFo = gm.class.getName().hashCode();
    }

    public final /* bridge */ /* synthetic */ boolean a(b bVar) {
        gm gmVar = (gm) bVar;
        l.bPG = gmVar.bPF.bPG;
        l.countryCode = gmVar.bPF.countryCode;
        return false;
    }
}
