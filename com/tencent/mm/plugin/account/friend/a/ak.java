package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.blw;
import com.tencent.mm.protocal.c.blx;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

public final class ak extends l implements k {
    private final b diG;
    private e diJ;

    public ak(String str) {
        a aVar = new a();
        aVar.dIG = new blw();
        aVar.dIH = new blx();
        aVar.uri = "/cgi-bin/micromsg-bin/newsetemailpwd";
        aVar.dIF = 382;
        aVar.dII = 181;
        aVar.dIJ = 1000000181;
        this.diG = aVar.KT();
        ((blw) this.diG.dID.dIL).rhI = bi.WN(str);
        x.d("MicroMsg.NetSceneSetEmailPwd", "md5 " + str);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final int getType() {
        return 382;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneSetEmailPwd", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        this.diJ.a(i2, i3, str, this);
    }
}
