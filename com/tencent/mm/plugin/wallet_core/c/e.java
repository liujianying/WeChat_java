package com.tencent.mm.plugin.wallet_core.c;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.zv;
import com.tencent.mm.protocal.c.zw;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends l implements k {
    private b diG;
    private com.tencent.mm.ab.e diJ;
    public zw pja;

    public e(String str) {
        a aVar = new a();
        aVar.dIG = new zv();
        aVar.dIH = new zw();
        aVar.uri = "/cgi-bin/mmpay-bin/tenpay/getbanpaymobileinfo";
        aVar.dIF = 1667;
        this.diG = aVar.KT();
        zv zvVar = (zv) this.diG.dID.dIL;
        x.d("MicroMsg.NetSceneGetBanpayMobileInfo", "req_key: %s", new Object[]{str});
        zvVar.bQa = str;
    }

    public final int getType() {
        return 1667;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetBanpayMobileInfo", "NetSceneGetBanpayMobileInfo, netId: %s, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        this.pja = (zw) this.diG.dIE.dIL;
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
