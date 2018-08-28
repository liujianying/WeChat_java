package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.aw;
import com.tencent.mm.protocal.c.vf;
import com.tencent.mm.protocal.c.vg;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends l implements k {
    private e diJ;
    private b eAN;
    public String ixy;
    public String kLZ;
    private vf kNo;
    private vg kNp;
    public String kNq;
    public String kNr;
    public int kNs;

    public d() {
        a aVar = new a();
        aVar.dIG = new vf();
        aVar.dIH = new vg();
        aVar.dIF = 1990;
        aVar.dII = 0;
        aVar.dIJ = 0;
        aVar.uri = "/cgi-bin/mmpay-bin/ftfhb/ffquerydowxhb";
        this.eAN = aVar.KT();
        this.kNo = (vf) this.eAN.dID.dIL;
        this.kNo.timestamp = System.currentTimeMillis() / 1000;
        aw bOL = i.bOL();
        if (bOL != null) {
            this.kNo.latitude = bOL.latitude;
            this.kNo.longitude = bOL.longitude;
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("NetSceneF2FLuckyMoneyQuery", "errType %d,errCode %d,errMsg %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.kNp = (vg) ((b) qVar).dIE.dIL;
        this.kLZ = this.kNp.kLZ;
        this.ixy = this.kNp.ixy;
        this.kNs = this.kNp.ryC;
        this.kNq = this.kNp.kNq;
        this.kNr = this.kNp.kNr;
        if (this.diJ != null) {
            this.diJ.a(i2, this.kNp.hUm, this.kNp.hUn, this);
        }
    }

    public final int getType() {
        return 1990;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.eAN, this);
    }
}
