package com.tencent.mm.plugin.profile.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.brs;
import com.tencent.mm.protocal.c.brt;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends l implements k {
    public b diG;
    private e diJ;

    public c(String str, boolean z) {
        a aVar = new a();
        aVar.dIG = new brs();
        aVar.dIH = new brt();
        aVar.uri = "/cgi-bin/mmocbiz-bin/switchbrand";
        aVar.dIF = 1394;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        brs brs = (brs) this.diG.dID.dIL;
        brs.riK = str;
        brs.spC = z;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.brandservice.NetSceneSwitchBrand", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1394;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        x.i("MicroMsg.brandservice.NetSceneSwitchBrand", "do scene");
        return a(eVar, this.diG, this);
    }

    public final brt bnk() {
        if (this.diG == null || this.diG.dIE.dIL == null) {
            return null;
        }
        return (brt) this.diG.dIE.dIL;
    }

    public final brs bnl() {
        if (this.diG == null || this.diG.dID.dIL == null) {
            return null;
        }
        return (brs) this.diG.dID.dIL;
    }
}
