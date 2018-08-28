package com.tencent.mm.plugin.account.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bbr;
import com.tencent.mm.protocal.c.fl;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends l implements k {
    private com.tencent.mm.ab.e diJ;
    private b eAN;
    private bbr eNZ;

    public e(int i) {
        a aVar = new a();
        aVar.dIG = new bbr();
        aVar.dIH = new fl();
        aVar.dIF = 268;
        aVar.dII = 0;
        aVar.dIJ = 0;
        aVar.uri = "/cgi-bin/micromsg-bin/privacypolicychoise";
        this.eAN = aVar.KT();
        this.eNZ = (bbr) this.eAN.dID.dIL;
        this.eNZ.sdR = i;
    }

    public final int getType() {
        return 268;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.eAN, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetScenePrivacyPolicyChoice", "errType %d,errCode %d,errMsg %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
