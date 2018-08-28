package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.abf;
import com.tencent.mm.protocal.c.abg;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa;

public final class y extends l implements k {
    private final b diG;
    private e diJ;

    public y() {
        a aVar = new a();
        aVar.dIG = new abf();
        aVar.dIH = new abg();
        aVar.uri = "/cgi-bin/micromsg-bin/getcardcount";
        aVar.dIF = 663;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
    }

    public final int getType() {
        return 663;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetCardCount", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            abg abg = (abg) this.diG.dIE.dIL;
            x.i("MicroMsg.NetSceneGetCardCount", "has_card_item:" + abg.rGi + " has_share_card:" + abg.rGj);
            if (abg.rGi > 0) {
                com.tencent.mm.plugin.card.d.l.azQ();
                if (TextUtils.isEmpty((String) g.Ei().DT().get(aa.a.sPR, null))) {
                    am.axh();
                    com.tencent.mm.plugin.card.b.b.nG(1);
                }
            }
            if (abg.rGj > 0) {
                com.tencent.mm.plugin.card.d.l.azS();
                Long l = (Long) g.Ei().DT().get(aa.a.sQb, Long.valueOf(0));
                if (l != null && l.longValue() == 0) {
                    am.axp().axD();
                }
            }
        }
        g.Ei().DT().set(282882, Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
        this.diJ.a(i2, i3, str, this);
    }
}
