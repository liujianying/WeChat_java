package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.bru;
import com.tencent.mm.protocal.c.brv;
import com.tencent.mm.sdk.platformtools.x;

public final class q extends l implements k {
    private b diG;
    private e diJ;
    public boolean iMJ = false;
    public boolean iMK = false;

    public q(int i) {
        a aVar = new a();
        aVar.dIG = new bru();
        aVar.dIH = new brv();
        aVar.uri = "/cgi-bin/micromsg-bin/switchopface";
        aVar.dIF = 938;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ((bru) this.diG.dID.dIL).qZc = i;
    }

    public final int getType() {
        return 938;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.q qVar, byte[] bArr) {
        brv brv = (brv) ((b) qVar).dIE.dIL;
        this.iMJ = brv.spD;
        this.iMK = brv.spE;
        x.i("MicroMsg.NetSceneFaceSwitchOpFace", "hy: NetSceneFaceSwitchOpFace errType: %d, errCode: %d, errMsg: %s, hasBio: %b, isOpen: %b", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, Boolean.valueOf(this.iMJ), Boolean.valueOf(this.iMK)});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
