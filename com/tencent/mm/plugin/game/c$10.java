package com.tencent.mm.plugin.game;

import com.tencent.mm.g.a.gq;
import com.tencent.mm.plugin.game.e.a.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;

class c$10 extends c<gq> {
    final /* synthetic */ c jFM;

    c$10(c cVar) {
        this.jFM = cVar;
        this.sFo = gq.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        gq gqVar = (gq) bVar;
        String str = gqVar.bPN.url;
        gqVar.bPO.bPP = a.jFu;
        switch (gqVar.bPN.nc) {
            case 1:
                gqVar.bPO.bPQ = a.aVh().DN(str);
                break;
            case 2:
                a.aVh().DO(str);
                break;
        }
        return false;
    }
}
