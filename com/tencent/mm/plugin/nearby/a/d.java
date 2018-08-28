package com.tencent.mm.plugin.nearby.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aqy;
import com.tencent.mm.protocal.c.aqz;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends l implements k {
    private final b diG;
    private e diJ;
    public String euq;
    public String lBn;

    public d(float f, float f2, int i, String str, String str2) {
        a aVar = new a();
        aVar.dIG = new aqy();
        aVar.dIH = new aqz();
        aVar.uri = "/cgi-bin/micromsg-bin/joinlbsroom";
        aVar.dIF = 376;
        aVar.dII = 183;
        aVar.dIJ = 1000000183;
        this.diG = aVar.KT();
        aqy aqy = (aqy) this.diG.dID.dIL;
        aqy.qZc = 1;
        aqy.rmr = f;
        aqy.rms = f2;
        aqy.ryV = i;
        aqy.ryW = str;
        aqy.ryX = str2;
        aqy.ryY = 0;
        x.d("MicroMsg.NetSceneLbsRoom", "Req: opcode:1 lon:" + f + " lat:" + f2 + " pre:" + i + " gpsSource:0 mac" + str + " cell:" + str2);
    }

    public d(String str, int i, int i2) {
        a aVar = new a();
        aVar.dIG = new aqy();
        aVar.dIH = new aqz();
        aVar.uri = "/cgi-bin/micromsg-bin/joinlbsroom";
        aVar.dIF = 376;
        aVar.dII = 183;
        aVar.dIJ = 1000000183;
        this.diG = aVar.KT();
        aqy aqy = (aqy) this.diG.dID.dIL;
        aqy.rmr = 0.0f;
        aqy.rms = 0.0f;
        aqy.ryV = 0;
        aqy.ryY = 0;
        aqy.ryW = "";
        aqy.ryX = "";
        aqy.qZc = 2;
        aqy.ebL = str;
        aqy.rTw = i;
        aqy.rTv = i2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 376;
    }

    public final int Oh() {
        return ((aqy) this.diG.dID.dIL).qZc;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneLbsRoom", "onGYNetEnd  errType:" + i2 + " errCode:" + i3 + " opCode:" + Oh());
        aqz aqz = (aqz) ((b) qVar).dIE.dIL;
        if (i2 != 0) {
            this.diJ.a(i2, i3, str, this);
        } else if (Oh() == 1) {
            this.euq = aqz.ebL;
            this.lBn = aqz.rTx;
            this.diJ.a(i2, i3, str, this);
        } else if (Oh() == 2) {
            b.IH(((aqy) ((b) qVar).dID.dIL).ebL);
            this.diJ.a(i2, i3, str, this);
        }
    }
}
