package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.d.bi;
import com.tencent.mm.plugin.game.d.bj;
import com.tencent.mm.plugin.game.d.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class ax extends l implements k {
    private e diJ;
    public final b ivx;

    public ax(String str, LinkedList<String> linkedList, s sVar, s sVar2, s sVar3, boolean z) {
        String str2;
        r rVar;
        x.i("MicroMsg.NetSceneGetGameIndexForeign", "lang = " + str + ", installedApp list size: " + linkedList.size());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            x.i("MicroMsg.NetSceneGetGameIndexForeign", "install id:[%s]", new Object[]{(String) it.next()});
        }
        bi biVar = new bi();
        biVar.jRj = str;
        biVar.jRK = linkedList;
        String dz = f.dz(ad.getContext());
        if (com.tencent.mm.sdk.platformtools.bi.oW(dz)) {
            dz = com.tencent.mm.sdk.platformtools.bi.fS(ad.getContext());
        }
        if (com.tencent.mm.sdk.platformtools.bi.oW(l.countryCode)) {
            str2 = dz;
        } else {
            str2 = l.countryCode;
        }
        biVar.eJQ = str2;
        if (sVar == null) {
            if (sVar2 != null) {
                sVar = sVar2;
            } else if (sVar3 != null) {
                sVar = sVar3;
            } else {
                sVar = null;
            }
        }
        biVar.jRL = new r();
        if (sVar != null) {
            biVar.jRL.jQa = sVar.jMt.jNi;
            biVar.jRL.jQb = sVar.field_appId;
            biVar.jRL.jOZ = sVar.jNb;
            if (sVar.field_msgType == 100) {
                biVar.jRL.jQd = sVar.jNa;
            } else {
                biVar.jRL.jQd = sVar.field_msgType;
            }
        }
        if (sVar2 != null) {
            rVar = biVar.jRL;
            rVar.jQc |= 1;
        }
        if (sVar3 != null) {
            rVar = biVar.jRL;
            rVar.jQc |= 2;
        }
        biVar.jRM = ((c) g.l(c.class)).aSj().aUf();
        biVar.jRN = z;
        biVar.jRk = com.tencent.mm.sdk.platformtools.e.chv() ? 1 : 0;
        x.i("MicroMsg.NetSceneGetGameIndexForeign", "Country Code: %s", new Object[]{str2});
        if (!com.tencent.mm.sdk.platformtools.bi.oW(biVar.eJQ) && "CN".equalsIgnoreCase(biVar.eJQ)) {
            h.mEJ.a(860, 8, 1, false);
        }
        a aVar = new a();
        aVar.dIG = biVar;
        aVar.dIH = new bj();
        aVar.uri = "/cgi-bin/mmgame-bin/getgameindexforeign";
        aVar.dIF = 2855;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.ivx = aVar.KT();
    }

    public final int getType() {
        return 2855;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.ivx, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetGameIndexForeign", "errType = " + i2 + ", errCode = " + i3);
        this.diJ.a(i2, i3, str, this);
    }
}
