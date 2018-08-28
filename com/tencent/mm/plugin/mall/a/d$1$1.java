package com.tencent.mm.plugin.mall.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mall.a.d.1;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

class d$1$1 implements Runnable {
    final /* synthetic */ String fhM;
    final /* synthetic */ 1 kYl;

    d$1$1(1 1, String str) {
        this.kYl = 1;
        this.fhM = str;
    }

    public final void run() {
        c bPK = c.bPK();
        String str = this.fhM;
        MallNews Pg = c.Pg(str);
        if (Pg == null) {
            return;
        }
        if ("2".equals(Pg.type)) {
            x.d("MicroMsg.MallNewsManager", "removeNews : " + Pg);
            MallNews mallNews = (MallNews) bPK.psm.get(Pg.psc);
            if (mallNews != null && mallNews.oqH.equals(Pg.oqH) && mallNews.bLe.equals(Pg.bLe)) {
                x.i("MicroMsg.MallNewsManager", "onRecieveMsg remove : " + Pg.psc);
                bPK.psm.remove(Pg.psc);
                return;
            }
            x.i("MicroMsg.MallNewsManager", "onRecieveMsg cancel not found!");
            return;
        }
        bPK.psm.put(Pg.psc, Pg);
        x.i("MicroMsg.MallNewsManager", "onRecieveMsg : " + str);
        bPK.bna();
        if (c.a(Pg)) {
            x.i("MicroMsg.MallNewsManager", "set OutOfDateRedDot");
            return;
        }
        if (Pg.showType == 0) {
            x.d("MicroMsg.MallNewsManager", "showType New");
            com.tencent.mm.s.c.Cp().u(262156, true);
            g.Ek();
            g.Ei().DT().a(a.sXJ, Long.valueOf(System.currentTimeMillis()));
        } else if (Pg.showType == 1) {
            x.d("MicroMsg.MallNewsManager", "showType Dot");
            com.tencent.mm.s.c.Cp().v(262156, true);
            g.Ek();
            g.Ei().DT().a(a.sXJ, Long.valueOf(System.currentTimeMillis()));
        }
        c.bPM();
    }
}
