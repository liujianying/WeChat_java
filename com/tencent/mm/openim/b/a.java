package com.tencent.mm.openim.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ca;
import com.tencent.mm.protocal.c.cb;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends l implements k {
    private final b diG;
    private e diJ;
    public String eup;

    public a(String str, String str2) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new ca();
        aVar.dIH = new cb();
        aVar.uri = "/cgi-bin/micromsg-bin/addopenimcontact";
        aVar.dIF = 667;
        this.diG = aVar.KT();
        this.eup = str;
        ca caVar = (ca) this.diG.dID.dIL;
        caVar.eup = str;
        caVar.rcw = str2;
        x.i("MicroMsg.NetSceneAddOpenIMContact", "tp_username: %s, antispam_ticket:%s", new Object[]{str, str2});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneAddOpenIMContact", "onGYNetEnd : errType : %d, errCode : %d, errMsg : %s, tp_username = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, this.eup});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 667;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
