package com.tencent.mm.av;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aqr;
import com.tencent.mm.protocal.c.blg;
import com.tencent.mm.protocal.c.blh;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends l implements k {
    private final b diG;
    private e diJ;
    String edM;

    public a(float f, float f2, int i, int i2, String str, String str2, int i3, int i4, String str3) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new blg();
        aVar.dIH = new blh();
        aVar.uri = "/cgi-bin/micromsg-bin/sensewhere";
        aVar.dIF = 752;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        aqr aqr = new aqr();
        aqr.ryX = str2;
        aqr.ryY = i2;
        aqr.rms = f2;
        aqr.rmr = f;
        aqr.ryW = str;
        aqr.ryV = i;
        blg blg = (blg) this.diG.dID.dIL;
        blg.rva = aqr;
        blg.sko = i3;
        blg.otY = i4;
        blg.jSA = str3;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneUploadSenseWhere", "upload sense where info. errType[%d] errCode[%d] errMsg[%s]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.edM = ((blh) ((b) qVar).dIE.dIL).jSA;
        } else {
            x.w("MicroMsg.NetSceneUploadSenseWhere", "upload sense where error");
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 752;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
