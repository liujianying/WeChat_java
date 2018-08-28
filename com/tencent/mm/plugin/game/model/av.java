package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.d.bc;
import com.tencent.mm.plugin.game.d.bd;
import com.tencent.mm.plugin.game.d.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class av extends l implements k {
    private e diJ;
    public final b ivx;

    public av(String str, LinkedList<String> linkedList, s sVar, s sVar2, s sVar3, boolean z) {
        String str2;
        r rVar;
        x.i("MicroMsg.NetSceneGetGameIndex4", "lang = " + str + ", installedApp list size: " + linkedList.size());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            x.i("MicroMsg.NetSceneGetGameIndex4", "install id:[%s]", new Object[]{(String) it.next()});
        }
        a aVar = new a();
        aVar.dIG = new bc();
        aVar.dIH = new bd();
        aVar.uri = "/cgi-bin/mmgame-bin/getgameindex4";
        aVar.dIF = 2994;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.ivx = aVar.KT();
        bc bcVar = (bc) this.ivx.dID.dIL;
        bcVar.jRj = str;
        bcVar.jRK = linkedList;
        String dz = f.dz(ad.getContext());
        if (bi.oW(dz)) {
            dz = bi.fS(ad.getContext());
        }
        if (bi.oW(l.countryCode)) {
            str2 = dz;
        } else {
            str2 = l.countryCode;
        }
        bcVar.eJQ = str2;
        if (sVar == null) {
            if (sVar2 != null) {
                sVar = sVar2;
            } else if (sVar3 != null) {
                sVar = sVar3;
            } else {
                sVar = null;
            }
        }
        bcVar.jRL = new r();
        if (sVar != null) {
            bcVar.jRL.jQa = sVar.jMt.jNi;
            bcVar.jRL.jQb = sVar.field_appId;
            bcVar.jRL.jOZ = sVar.jNb;
            if (sVar.field_msgType == 100) {
                bcVar.jRL.jQd = sVar.jNa;
            } else {
                bcVar.jRL.jQd = sVar.field_msgType;
            }
        }
        if (sVar2 != null) {
            rVar = bcVar.jRL;
            rVar.jQc |= 1;
        }
        if (sVar3 != null) {
            rVar = bcVar.jRL;
            rVar.jQc |= 2;
        }
        bcVar.jRM = ((c) g.l(c.class)).aSj().aUf();
        bcVar.jRN = z;
        bcVar.jRk = com.tencent.mm.sdk.platformtools.e.chv() ? 1 : 0;
        x.i("MicroMsg.NetSceneGetGameIndex4", "Country Code: %s", new Object[]{str2});
        if (!bi.oW(bcVar.eJQ) && !"CN".equalsIgnoreCase(bcVar.eJQ)) {
            h.mEJ.a(860, 7, 1, false);
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.ivx, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetGameIndex4", "errType = " + i2 + ", errCode = " + i3);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 2994;
    }
}
