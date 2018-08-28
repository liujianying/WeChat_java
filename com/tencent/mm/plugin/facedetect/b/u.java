package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aah;
import com.tencent.mm.protocal.c.aai;
import com.tencent.mm.sdk.platformtools.x;

public final class u extends l implements k, b {
    private b diG;
    private e diJ;
    private long iML = -1;
    private byte[] iMM = null;

    public final long aJp() {
        return this.iML;
    }

    public final byte[] aJq() {
        return this.iMM;
    }

    public u(int i) {
        a aVar = new a();
        aVar.dIG = new aah();
        aVar.dIH = new aai();
        aVar.uri = "/cgi-bin/micromsg-bin/getbioconfig";
        aVar.dIF = 732;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        aah aah = (aah) this.diG.dID.dIL;
        aah.hcE = 1;
        aah.otY = i;
    }

    public final int getType() {
        return 732;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        aai aai = (aai) ((b) qVar).dIE.dIL;
        if (i2 == 0 && i3 == 0) {
            this.iML = aai.rFP;
            this.iMM = aai.rFQ.lR;
            String str2 = "MicroMsg.NetSceneGetBioConfig";
            String str3 = "hy: get bio config: bioId: %s, bioConfigSize: %d";
            Object[] objArr = new Object[2];
            objArr[0] = Long.valueOf(this.iML);
            objArr[1] = Integer.valueOf(this.iMM == null ? 0 : this.iMM.length);
            x.i(str2, str3, objArr);
        }
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
