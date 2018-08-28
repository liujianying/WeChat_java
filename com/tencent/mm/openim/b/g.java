package com.tencent.mm.openim.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bxr;
import com.tencent.mm.protocal.c.bxs;
import com.tencent.mm.sdk.platformtools.x;

public final class g extends l implements k {
    private final b diG;
    private e diJ;
    public String eup;

    public g(String str, String str2) {
        a aVar = new a();
        aVar.dIG = new bxr();
        aVar.dIH = new bxs();
        aVar.uri = "/cgi-bin/micromsg-bin/verifyopenimcontact";
        aVar.dIF = 853;
        this.diG = aVar.KT();
        this.eup = str;
        bxr bxr = (bxr) this.diG.dID.dIL;
        bxr.eup = str;
        bxr.stS = str2;
        x.i("MicroMsg.FreeWifi.NetSceneVerifyOpenIMContact", "tp_username: %s, verify_ticket:%s", new Object[]{str, str2});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.FreeWifi.NetSceneVerifyOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, this.eup});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 853;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
