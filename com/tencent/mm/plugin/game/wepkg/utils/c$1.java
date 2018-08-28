package com.tencent.mm.plugin.game.wepkg.utils;

import com.tencent.mm.g.a.ou;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

class c$1 extends c<ou> {
    final /* synthetic */ c kgq;

    c$1(c cVar) {
        this.kgq = cVar;
        this.sFo = ou.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        x.i("MicroMsg.Wepkg.WepkgListener", "sendEntranceStateListener isInFindEntrance:%b", new Object[]{Boolean.valueOf(((ou) bVar).bZO.bQt)});
        if (((ou) bVar).bZO.bQt && bi.bG(Long.valueOf(bi.c((Long) g.Ei().DT().get(a.sXS, Long.valueOf(0)))).longValue()) > 60) {
            g.Ei().DT().a(a.sXS, Long.valueOf(bi.VE()));
            c.a(this.kgq, 2);
        }
        return false;
    }
}
