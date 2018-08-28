package com.tencent.mm.plugin.topstory.a.c;

import android.os.Build.VERSION;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.websearch.api.ad;
import com.tencent.mm.plugin.websearch.api.p;
import com.tencent.mm.protocal.c.bth;
import com.tencent.mm.protocal.c.cfi;
import com.tencent.mm.protocal.c.cfj;
import com.tencent.mm.protocal.c.ps;
import com.tencent.mm.sdk.platformtools.x;
import java.util.Iterator;

public final class b extends l implements k {
    private com.tencent.mm.ab.b diG;
    private e diJ;
    public bth ozl;

    public b(bth bth) {
        x.i("MicroMsg.TopStory.NetSceneTopStory", "Create NetSceneTopStory Video %s", new Object[]{bth.sqA, bth.fuu});
        this.ozl = bth;
        a aVar = new a();
        aVar.dIF = 1943;
        aVar.uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
        aVar.dIG = new cfi();
        aVar.dIH = new cfj();
        this.diG = aVar.KT();
        cfi cfi = (cfi) this.diG.dID.dIL;
        cfi.rjC = bth.offset;
        cfi.rUH = p.zP(1);
        cfi.rDH = bth.bHt;
        cfi.rUI = p.JU();
        cfi.otY = bth.scene;
        cfi.rlo = bth.fuu;
        cfi.szQ.addAll(bth.pKZ);
        cfi.spQ = (int) bth.sqL;
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
        ad.reportIdKey649ForLook(this.ozl.scene, 2);
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.TopStory.NetSceneTopStory", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.diJ.a(i2, i3, str, this);
    }

    public final cfj bHD() {
        return (cfj) this.diG.dIE.dIL;
    }
}
