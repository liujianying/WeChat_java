package com.tencent.mm.plugin.setting.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bki;
import com.tencent.mm.protocal.c.bkj;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends l implements k {
    private final b diG;
    private e diJ;

    public j(String str, String str2) {
        this(str, str2, 0);
    }

    public j(String str, String str2, int i) {
        a aVar = new a();
        aVar.dIG = new bki();
        aVar.dIH = new bkj();
        aVar.uri = "/cgi-bin/micromsg-bin/sendfeedback";
        aVar.dIF = 153;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bki bki = (bki) this.diG.dID.dIL;
        bki.sjX = str;
        bki.jSA = str2;
        bki.rSC = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 153;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSendSceneFeedBack", "onGYNetEnd type:" + i2 + " code:" + i3);
        this.diJ.a(i2, i3, str, this);
    }
}
