package com.tencent.mm.plugin.address.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.sb;
import com.tencent.mm.protocal.c.sc;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends l implements k {
    private b diG;
    private e diJ;

    public a(int i) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new sb();
        aVar.dIH = new sc();
        aVar.uri = "/cgi-bin/mmbiz-bin/wxaapp/autofill/deleteinfo";
        aVar.dIF = 1194;
        this.diG = aVar.KT();
        sb sbVar = (sb) this.diG.dID.dIL;
        sbVar.rvy = "invoice_info";
        sbVar.group_id = i;
        sbVar.source = 2;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneDeleteUserAutoFillInfo", "errType:" + i2 + ",errCode:" + i3 + ",errMsg" + str);
        if (i2 == 0 && i3 == 0) {
            x.i("MicroMsg.NetSceneDeleteUserAutoFillInfo", "");
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1194;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
