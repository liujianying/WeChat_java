package com.tencent.mm.plugin.luckymoney.f2f.a;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.wallet_core.model.i;
import com.tencent.mm.protocal.c.aw;
import com.tencent.mm.protocal.c.bfi;
import com.tencent.mm.protocal.c.vd;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends l implements k {
    public int amount;
    public int bJL;
    public int ceS;
    private e diJ;
    private com.tencent.mm.ab.b eAN;
    public String kLZ;
    private vd kNb;
    private ve kNc;
    public int kNd;
    public String kNe;
    public bfi kNf;
    public int kNg;
    public String kNh;
    public String kNi;
    public String kNj;
    public int kNk;

    public b(String str) {
        a aVar = new a();
        aVar.dIG = new vd();
        aVar.dIH = new ve();
        aVar.dIF = 1997;
        aVar.dII = 0;
        aVar.dIJ = 0;
        aVar.uri = "/cgi-bin/mmpay-bin/ftfhb/ffopenwxhb";
        this.eAN = aVar.KT();
        this.kNb = (vd) this.eAN.dID.dIL;
        this.kNb.ixy = str;
        aw bOL = i.bOL();
        if (bOL != null) {
            this.kNb.csL = bOL.csL;
            this.kNb.csK = bOL.csK;
            this.kNb.ryw = bOL.raZ;
            this.kNb.ryx = bOL.rba;
            this.kNb.ryy = bOL.raY;
            this.kNb.ryz = bOL.latitude;
            this.kNb.ryA = bOL.longitude;
        }
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.kNc = (ve) ((com.tencent.mm.ab.b) qVar).dIE.dIL;
        x.i("NetSceneF2FLuckyMoneyOpen", "errType %d, retCode %d, retMsg %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(this.kNc.hUm), this.kNc.hUn});
        this.kLZ = this.kNc.kLZ;
        this.ceS = this.kNc.ceS;
        this.kNd = this.kNc.ceT;
        this.bJL = this.kNc.bJL;
        this.kNe = this.kNc.kQg;
        this.amount = this.kNc.amount;
        this.kNf = this.kNc.ryB;
        this.kNg = this.kNc.kNg;
        this.kNh = this.kNc.kNh;
        this.kNi = this.kNc.kNi;
        this.kNj = this.kNc.kNj;
        this.kNk = this.kNc.kNk;
        if (this.diJ != null) {
            this.diJ.a(i2, this.kNc.hUm, this.kNc.hUn, this);
        }
    }

    public final int getType() {
        return 1997;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.eAN, this);
    }
}
