package com.tencent.mm.plugin.remittance.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.lq;
import com.tencent.mm.protocal.c.lr;
import com.tencent.mm.sdk.platformtools.x;

public final class o extends l implements k {
    private e diJ;
    private b eAN;
    private lq mxt;
    public lr mxu;

    public o(String str, String str2, int i, String str3, String str4, int i2, int i3, String str5, String str6) {
        a aVar = new a();
        aVar.dIG = new lq();
        aVar.dIH = new lr();
        aVar.dIF = 2773;
        aVar.uri = "/cgi-bin/mmpay-bin/f2fsucpage";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.eAN = aVar.KT();
        this.mxt = (lq) this.eAN.dID.dIL;
        this.mxt.rcD = str;
        this.mxt.rcE = str2;
        this.mxt.amount = i;
        this.mxt.myf = str3;
        this.mxt.mye = str4;
        this.mxt.bVU = i2;
        this.mxt.mwQ = i3;
        this.mxt.rpL = str5;
        this.mxt.rpM = str6;
    }

    public final int getType() {
        return 2773;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.eAN, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneF2fSuccPage", "errType: %s, errCode: %s, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.mxu = (lr) ((b) qVar).dIE.dIL;
        x.i("MicroMsg.NetSceneF2fSuccPage", "ret_code: %s, ret_msg: %s", new Object[]{Integer.valueOf(this.mxu.hUm), this.mxu.hUn});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
