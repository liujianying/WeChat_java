package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.aw;
import com.tencent.mm.protocal.c.vh;
import com.tencent.mm.protocal.c.vi;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.wallet_core.c.d;

public final class c extends l implements k, d {
    public String bOd;
    private e diJ;
    private b eAN;
    public String kLZ;
    private vh kNl;
    private vi kNm;
    public String kNn;

    public c(int i, int i2, int i3, int i4) {
        a aVar = new a();
        aVar.dIG = new vh();
        aVar.dIH = new vi();
        aVar.dIF = 1970;
        aVar.dII = 0;
        aVar.dIJ = 0;
        aVar.uri = "/cgi-bin/mmpay-bin/ftfhb/ffrequestwxhb";
        this.eAN = aVar.KT();
        this.kNl = (vh) this.eAN.dID.dIL;
        this.kNl.hUg = i;
        this.kNl.lTc = i2;
        this.kNl.kPI = i3;
        this.kNl.ryD = i4;
        aw bOL = i.bOL();
        if (bOL != null) {
            this.kNl.latitude = bOL.latitude;
            this.kNl.longitude = bOL.longitude;
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("NetSceneF2FLuckyMoneyPrepare", "errType %d,errCode %d,errMsg %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.kNm = (vi) ((b) qVar).dIE.dIL;
        this.bOd = this.kNm.kRq;
        this.kLZ = this.kNm.kLZ;
        this.kNn = this.kNm.kRx;
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1970;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.eAN, this);
    }
}
