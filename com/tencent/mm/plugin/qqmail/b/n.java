package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bry;
import com.tencent.mm.protocal.c.brz;
import com.tencent.mm.sdk.platformtools.bi;

public final class n extends l implements k {
    public final boolean ccZ;
    private b diG;
    private e diJ;
    private String mcY = "";

    public n(boolean z, String str) {
        this.ccZ = z;
        this.mcY = bi.oV(str);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        a aVar = new a();
        aVar.dIG = new bry();
        aVar.dIH = new brz();
        aVar.uri = "/cgi-bin/micromsg-bin/switchpushmail";
        aVar.dIF = 129;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bry bry = (bry) this.diG.dID.dIL;
        bry.rDA = this.ccZ ? 1 : 2;
        bry.spG = this.mcY;
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final boolean KX() {
        return true;
    }

    public final int getType() {
        return 24;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            brz brz = (brz) this.diG.dIE.dIL;
            au.HU();
            c.DT().set(17, Integer.valueOf(brz.rDA));
        }
        this.diJ.a(i2, i3, str, this);
    }
}
