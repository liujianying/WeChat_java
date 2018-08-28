package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.md;
import com.tencent.mm.protocal.c.me;
import com.tencent.mm.sdk.platformtools.x;

public final class n extends l implements k {
    private e diJ;
    private b eAN;
    private md mxs;

    public n(String str, String str2, String str3, String str4, int i) {
        a aVar = new a();
        aVar.dIG = new md();
        aVar.dIH = new me();
        aVar.dIF = 1273;
        aVar.uri = "/cgi-bin/mmpay-bin/f2fpaycheck";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.eAN = aVar.KT();
        this.mxs = (md) this.eAN.dID.dIL;
        this.mxs.rcD = str;
        this.mxs.rcE = str2;
        this.mxs.rqo = str3;
        this.mxs.rqp = str4;
        this.mxs.amount = i;
        x.d("MicroMsg.NetSceneF2fPayCheck", "NetSceneF2fPayCheck, f2fId: %s, transId: %s, extendStr: %s, amount: %s", new Object[]{str, str2, str3, Integer.valueOf(i)});
    }

    public final int getType() {
        return 1273;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.eAN, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneF2fPayCheck", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
