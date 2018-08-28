package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bxo;
import com.tencent.mm.protocal.c.bxp;
import com.tencent.mm.sdk.platformtools.x;

public final class s extends l implements k, e {
    private b diG;
    private e diJ;
    private boolean iMA = false;

    public s(long j, String str, String str2) {
        a aVar = new a();
        aVar.dIG = new bxo();
        aVar.dIH = new bxp();
        aVar.uri = "/cgi-bin/micromsg-bin/verifyface";
        aVar.dIF = 797;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bxo bxo = (bxo) this.diG.dID.dIL;
        bxo.rFP = j;
        bxo.sha = str;
        bxo.shb = str2;
    }

    public final int getType() {
        return 797;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        bxp bxp = (bxp) ((b) qVar).dIE.dIL;
        if (i2 == 0 && i3 == 0) {
            this.iMA = bxp.shd == 0;
            i3 = bxp.shd;
            x.i("MicroMsg.NetSceneFaceVerifyFace", "hy: is Verified: %b", new Object[]{Boolean.valueOf(this.iMA)});
        } else if (!(bxp == null || bxp.shd == 0)) {
            x.i("MicroMsg.NetSceneFaceVerifyFace", "hy: has DetailRet, use it");
            i3 = bxp.shd;
        }
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final boolean aJr() {
        return true;
    }

    public final String aJs() {
        return null;
    }
}
