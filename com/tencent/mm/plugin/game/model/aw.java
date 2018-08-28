package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.d.bg;
import com.tencent.mm.plugin.game.d.bh;
import com.tencent.mm.plugin.game.d.r;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;
import java.util.LinkedList;

public final class aw extends l implements k {
    private e diJ;
    public final b ivx;

    public aw(String str, LinkedList<String> linkedList, s sVar, s sVar2, s sVar3, boolean z) {
        String str2;
        r rVar;
        x.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "lang = " + str + ", installedApp list size: " + linkedList.size());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            x.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "install id:[%s]", new Object[]{(String) it.next()});
        }
        bg bgVar = new bg();
        bgVar.jRj = str;
        bgVar.jRK = linkedList;
        String dz = f.dz(ad.getContext());
        if (bi.oW(dz)) {
            dz = bi.fS(ad.getContext());
        }
        if (bi.oW(l.countryCode)) {
            str2 = dz;
        } else {
            str2 = l.countryCode;
        }
        bgVar.eJQ = str2;
        if (sVar == null) {
            if (sVar2 != null) {
                sVar = sVar2;
            } else if (sVar3 != null) {
                sVar = sVar3;
            } else {
                sVar = null;
            }
        }
        bgVar.jRL = new r();
        if (sVar != null) {
            bgVar.jRL.jQa = sVar.jMt.jNi;
            bgVar.jRL.jQb = sVar.field_appId;
            bgVar.jRL.jOZ = sVar.jNb;
            if (sVar.field_msgType == 100) {
                bgVar.jRL.jQd = sVar.jNa;
            } else {
                bgVar.jRL.jQd = sVar.field_msgType;
            }
        }
        if (sVar2 != null) {
            rVar = bgVar.jRL;
            rVar.jQc |= 1;
        }
        if (sVar3 != null) {
            rVar = bgVar.jRL;
            rVar.jQc |= 2;
        }
        bgVar.jRM = ((c) g.l(c.class)).aSj().aUf();
        bgVar.jRN = z;
        bgVar.jRk = com.tencent.mm.sdk.platformtools.e.chv() ? 1 : 0;
        x.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "Country Code: %s", new Object[]{str2});
        a aVar = new a();
        aVar.dIG = bgVar;
        aVar.dIH = new bh();
        aVar.uri = "/cgi-bin/mmgame-bin/getgameindexdownloadguidance";
        aVar.dIF = 2586;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.ivx = aVar.KT();
    }

    public final int getType() {
        return 2586;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.ivx, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetGameIndexDownloadGuidance", "errType = " + i2 + ", errCode = " + i3);
        this.diJ.a(i2, i3, str, this);
    }
}
