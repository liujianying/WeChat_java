package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bfx;
import com.tencent.mm.protocal.c.bfy;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends l implements k, e {
    private b diG;
    private e diJ;
    private boolean iMA = false;
    private String iME = null;

    public n(long j, String str, String str2) {
        a aVar = new a();
        aVar.dIG = new bfx();
        aVar.dIH = new bfy();
        aVar.uri = "/cgi-bin/micromsg-bin/registerface";
        aVar.dIF = 918;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bfx bfx = (bfx) this.diG.dID.dIL;
        bfx.rFP = j;
        bfx.sha = str;
        bfx.shb = str2;
    }

    public final int getType() {
        return 918;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        bfy bfy = (bfy) ((b) qVar).dIE.dIL;
        if (i2 == 0 && i3 == 0) {
            this.iMA = bfy.shd == 0;
            this.iME = bfy.shc;
            i3 = bfy.shd;
            x.i("MicroMsg.NetSceneFaceRegFace", "hy: is Verified: %b", new Object[]{Boolean.valueOf(this.iMA)});
        } else if (!(bfy == null || bfy.shd == 0)) {
            x.i("MicroMsg.NetSceneFaceRegFace", "hy: has detail ret. use");
            i3 = bfy.shd;
        }
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final boolean aJr() {
        return true;
    }

    public final String aJs() {
        return this.iME;
    }
}
