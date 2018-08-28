package com.tencent.mm.plugin.setting.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.protocal.c.bjy;
import com.tencent.mm.protocal.c.bjz;

public final class i extends l implements k {
    private String bHt;
    private e diJ;
    public byte[] mOK;
    public bjz mON;

    public i(String str) {
        this.bHt = str;
    }

    public i(byte[] bArr) {
        this.mOK = bArr;
    }

    public final int getType() {
        return 1169;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        a aVar = new a();
        bjy bjy = new bjy();
        bjy.bHt = this.bHt;
        if (this.mOK != null) {
            bjy.rLH = ab.O(this.mOK).siK;
        }
        aVar.dIG = bjy;
        aVar.dIH = new bjz();
        aVar.dIF = 1169;
        aVar.uri = "/cgi-bin/mmbiz-bin/searchuserauth";
        aVar.dII = 0;
        aVar.dIJ = 0;
        return a(eVar, aVar.KT(), this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.mON = (bjz) ((b) qVar).dIE.dIL;
        this.diJ.a(i2, this.mON.rvs.bMH, this.mON.rvs.bMI, this);
    }
}
