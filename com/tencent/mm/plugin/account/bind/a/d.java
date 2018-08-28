package com.tencent.mm.plugin.account.bind.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.buj;
import com.tencent.mm.protocal.c.buk;

public final class d extends l implements k {
    private b diG;
    private e diJ;

    public d(String str) {
        a aVar = new a();
        aVar.dIG = new buj();
        aVar.dIH = new buk();
        aVar.uri = "/cgi-bin/micromsg-bin/unbindqq";
        aVar.dIF = 253;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ((buj) this.diG.dID.dIL).rwj = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 253;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.diJ.a(i2, i3, str, this);
    }
}
