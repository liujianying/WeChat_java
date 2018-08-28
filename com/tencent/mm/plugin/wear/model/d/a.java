package com.tencent.mm.plugin.wear.model.d;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.amc;
import com.tencent.mm.protocal.c.amd;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends l implements k {
    public String bKv;
    public String byN;
    private b dZf;
    private e diJ;

    public a(String str, String str2) {
        this.byN = str;
        this.bKv = str2;
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.uri = "/cgi-bin/mmbiz-bin/device/register";
        aVar.dIG = new amc();
        aVar.dIH = new amd();
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.dZf = aVar.KT();
        amc amc = (amc) this.dZf.dID.dIL;
        amc.rgs = new com.tencent.mm.bk.b(str.getBytes());
        amc.rgu = new com.tencent.mm.bk.b(str2.getBytes());
        amc.rOO = new com.tencent.mm.bk.b("5".getBytes());
    }

    public final int getType() {
        return 1091;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.dZf, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.Wear.NetSceneBizDeviceAuth", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.diJ.a(i2, i3, str, this);
    }
}
