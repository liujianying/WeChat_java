package com.tencent.mm.wallet_core.c;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.baa;
import com.tencent.mm.protocal.c.bab;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends m {
    private b diG;
    private e diJ;

    public j(String str) {
        this(str, null, null, -1, -1, -1);
    }

    public j(String str, String str2, String str3, int i, int i2, int i3) {
        a aVar = new a();
        aVar.dIG = new baa();
        aVar.dIH = new bab();
        aVar.uri = "/cgi-bin/mmpay-bin/paysubscribe";
        aVar.dIF = 421;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        baa baa = (baa) this.diG.dID.dIL;
        baa.scJ = str;
        baa.rmQ = i.bOL();
        baa.scK = str3;
        if (!bi.oW(str2)) {
            baa.scL = new com.tencent.mm.bk.b(str2.getBytes());
        }
        if (i >= 0) {
            baa.rmJ = i;
        }
        if (i2 >= 0) {
            baa.qZe = i2;
        }
        if (i3 >= 0) {
            baa.scM = i3;
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void e(int i, int i2, String str, q qVar) {
        x.d("MicroMsg.NetScenePaySubscribe", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        this.diJ.a(i, i2, str, this);
    }

    public final int getType() {
        return 421;
    }
}
