package com.tencent.mm.plugin.wallet_ecard.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.gw;
import com.tencent.mm.protocal.c.gx;
import com.tencent.mm.sdk.platformtools.x;

public final class c extends l implements k {
    private b diG;
    private e diJ;
    public gx pBX;

    public c(String str, String str2, String str3, String str4, int i) {
        a aVar = new a();
        aVar.dIG = new gw();
        aVar.dIH = new gx();
        aVar.dIF = 1986;
        aVar.uri = "/cgi-bin/mmpay-bin/bindecard";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        gw gwVar = (gw) this.diG.dID.dIL;
        gwVar.rhb = str;
        gwVar.rhc = str2;
        gwVar.pqM = str3;
        gwVar.rhd = str4;
        gwVar.bVB = i;
        x.i("MicroMsg.NetSceneBindECard", "cardType: %s, reqSerial: %s, openScene: %s, verifyCode: %s, bindToken: %s", new Object[]{str, str2, Integer.valueOf(i), str3, str4});
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneBindECard", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.pBX = (gx) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneBindECard", "ret_code: %d, ret_msg: %s", new Object[]{Integer.valueOf(this.pBX.hwV), this.pBX.hwW});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1986;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
