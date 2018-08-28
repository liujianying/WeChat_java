package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bux;
import com.tencent.mm.protocal.c.buy;

public final class y extends l implements k {
    private String bKv;
    private String byN;
    public String cCR;
    private b diG;
    private e diJ;
    private int ivI = 0;

    public y(String str, String str2, String str3) {
        this.cCR = str3;
        this.byN = str;
        this.bKv = str2;
    }

    public final int getType() {
        return 1263;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        a aVar = new a();
        aVar.dIG = new bux();
        aVar.dIH = new buy();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/updatemydeviceattr";
        aVar.dIF = 1263;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bux bux = (bux) this.diG.dID.dIL;
        bux.cCR = this.cCR;
        bux.lKa = this.byN;
        bux.devicetype = this.bKv;
        bux.srT = this.ivI;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.diJ.a(i2, i3, str, this);
    }
}
