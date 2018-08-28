package com.tencent.mm.plugin.websearch.api;

import android.os.Build.VERSION;
import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.cfi;
import com.tencent.mm.protocal.c.cfj;
import com.tencent.mm.protocal.c.ps;
import com.tencent.mm.sdk.platformtools.x;

public final class k extends a implements com.tencent.mm.network.k {
    private j dFC;
    private b diG;
    private e diJ;

    public k(j jVar) {
        boolean z = true;
        this.dFC = jVar;
        this.pKM = jVar.bHt;
        this.tH = jVar.offset;
        this.fdx = jVar.scene;
        this.pKL = jVar.bWo;
        this.dFC = jVar;
        this.pKN = jVar.pLg;
        a aVar = new a();
        aVar.dIF = 1943;
        aVar.uri = "/cgi-bin/mmsearch-bin/mmwebrecommend";
        aVar.dIG = new cfi();
        aVar.dIH = new cfj();
        this.diG = aVar.KT();
        cfi cfi = (cfi) this.diG.dID.dIL;
        cfi.rjC = jVar.offset;
        cfi.rUH = p.zP(1);
        cfi.shN = jVar.pKO;
        cfi.rDH = jVar.bHt;
        cfi.rUI = p.JU();
        cfi.otY = jVar.scene;
        cfi.rlo = jVar.iow;
        cfi.szP = jVar.pKQ;
        cfi.syI = jVar.pKV;
        cfi.spQ = jVar.bxk;
        cfi.szR = jVar.pLi;
        ps psVar = new ps();
        psVar.aAL = "client_system_version";
        psVar.rtU = (long) VERSION.SDK_INT;
        jVar.pKZ.add(psVar);
        cfi.szQ = jVar.pKZ;
        cfi.syL = jVar.bJK;
        this.bWs = jVar.kJG;
        if (jVar.pLj) {
            int i = jVar.scene;
            String str = jVar.bJK;
            String str2 = jVar.bWr;
            String str3 = jVar.iow;
            int i2 = jVar.offset;
            if (jVar.pKO != 1) {
                z = false;
            }
            o.a(i, str, str2, str3, i2, z, jVar.kJG, jVar.bHt, jVar.iPZ, jVar.pLf);
        }
    }

    public final int getType() {
        return 1943;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        ad.reportIdKey649ForLook(this.fdx, 2);
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.FTS.NetSceneWebRecommend", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        boolean z = i2 == 0 && i3 == 0;
        if (this.dFC.pLj) {
            o.a(this.dFC.scene, this.dFC.bJK, this.dFC.bWr, this.dFC.iow, this.dFC.offset, this.dFC.pKO == 1, this.dFC.kJG, z, this.dFC.bHt, this.dFC.iPZ, this.dFC.pLf);
        }
        if (i3 == -1) {
            ad.reportIdKey649ForLook(this.fdx, 4);
        } else if (i2 == 0 && i3 == 0) {
            ad.reportIdKey649ForLook(this.fdx, 3);
        } else {
            ad.reportIdKey649ForLook(this.fdx, 8);
        }
        this.diJ.a(i2, i3, str, this);
    }

    private cfj bSJ() {
        return (cfj) this.diG.dIE.dIL;
    }

    public final String JS() {
        return bSJ() != null ? bSJ().rjK : "";
    }

    public final int JT() {
        return bSJ() != null ? bSJ().syR : 0;
    }
}
