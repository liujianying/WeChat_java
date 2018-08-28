package com.tencent.mm.openim.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bkq;
import com.tencent.mm.protocal.c.bkr;
import com.tencent.mm.sdk.platformtools.x;

public final class f extends l implements k {
    private final b diG;
    private e diJ;
    private String eup;

    public f(String str, String str2, String str3) {
        this.eup = str;
        a aVar = new a();
        aVar.dIG = new bkq();
        aVar.dIH = new bkr();
        aVar.uri = "/cgi-bin/micromsg-bin/sendopenimverifyrequest";
        aVar.dIF = 243;
        this.diG = aVar.KT();
        bkq bkq = (bkq) this.diG.dID.dIL;
        bkq.eup = str;
        bkq.skb = str2;
        bkq.rcw = str3;
        x.i("MicroMsg.NetSceneSendOpenIMVerifyRequest", "init user:%s anti:%s", new Object[]{str, str3});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 243;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneSendOpenIMVerifyRequest", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, this.eup});
        if (!(i2 == 0 && i3 == 0)) {
            x.e("MicroMsg.NetSceneSendOpenIMVerifyRequest", "errType:%d, errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        }
        this.diJ.a(i2, i3, str, this);
    }
}
