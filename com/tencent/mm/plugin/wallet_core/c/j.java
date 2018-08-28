package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.uk;
import com.tencent.mm.protocal.c.ul;
import com.tencent.mm.sdk.platformtools.x;

public final class j extends l implements k {
    private e diJ;
    private b eAN;
    private boolean pjf;
    private uk pjl;
    public ul pjm;

    public j(String str, boolean z) {
        this.pjf = z;
        a aVar = new a();
        aVar.dIG = new uk();
        aVar.dIH = new ul();
        if (z) {
            aVar.dIF = 2529;
            aVar.uri = "/cgi-bin/mmpay-bin/mktf2fmodifyexposure";
        } else {
            aVar.dIF = 2888;
            aVar.uri = "/cgi-bin/mmpay-bin/mktmodifyexposure";
        }
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.eAN = aVar.KT();
        this.pjl = (uk) this.eAN.dID.dIL;
        this.pjl.rxR = str;
    }

    public final int getType() {
        if (this.pjf) {
            return 2529;
        }
        return 2888;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.eAN, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneMktModifyExposure", "onGYNetEnd, netId: %s, errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.pjm = (ul) ((b) qVar).dIE.dIL;
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
