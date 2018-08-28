package com.tencent.mm.plugin.topstory.a.c;

import android.os.Build.VERSION;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.protocal.c.bte;
import com.tencent.mm.protocal.c.cfi;
import com.tencent.mm.protocal.c.cfj;
import com.tencent.mm.protocal.c.ps;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

public final class a extends l implements k {
    public bte ccA;
    private b diG;
    private e diJ;

    public a(bte bte) {
        x.i("MicroMsg.TopStory.NetSceneTopStory", "Create NetSceneTopStory Home %s %s", new Object[]{bte.sqA, bte.bJK});
        this.ccA = bte;
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIF = 1943;
        aVar.uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
        aVar.dIG = new cfi();
        aVar.dIH = new cfj();
        this.diG = aVar.KT();
        cfi cfi = (cfi) this.diG.dID.dIL;
        cfi.rjC = bte.offset;
        cfi.rUH = p.zP(1);
        cfi.rDH = bte.bHt;
        cfi.rUI = p.JU();
        cfi.otY = bte.scene;
        cfi.rlo = bte.fuu;
        cfi.szQ.addAll(bte.pKZ);
        cfi.spQ = bte.bxk;
        cfi.szR = bte.pLi;
        ps psVar = new ps();
        psVar.aAL = "client_system_version";
        psVar.rtU = (long) VERSION.SDK_INT;
        cfi.szQ.add(psVar);
        psVar = new ps();
        psVar.aAL = "nettype";
        psVar.rtV = p.bjC();
        cfi.szQ.add(psVar);
        psVar = new ps();
        psVar.aAL = "client_request_time";
        psVar.rtV = String.valueOf(System.currentTimeMillis());
        cfi.szQ.add(psVar);
        Iterator it = cfi.szQ.iterator();
        while (it.hasNext()) {
            ps psVar2 = (ps) it.next();
            x.i("MicroMsg.TopStory.NetSceneTopStory", "key: %s unit_value %s text_value %s", new Object[]{psVar2.aAL, Long.valueOf(psVar2.rtU), psVar2.rtV});
        }
    }

    public final int getType() {
        return 1943;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        ad.reportIdKey649ForLook(this.ccA.scene, 2);
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.TopStory.NetSceneTopStory", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i3 == -1) {
            ad.reportIdKey649ForLook(this.ccA.scene, 4);
        } else if (i2 == 0 && i3 == 0) {
            ad.reportIdKey649ForLook(this.ccA.scene, 3);
        } else {
            ad.reportIdKey649ForLook(this.ccA.scene, 8);
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final cfj bHD() {
        return (cfj) this.diG.dIE.dIL;
    }
}
