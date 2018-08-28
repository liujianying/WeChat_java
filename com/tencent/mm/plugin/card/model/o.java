package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aj;
import com.tencent.mm.protocal.c.ak;
import com.tencent.mm.protocal.c.bqs;
import com.tencent.mm.sdk.platformtools.x;

public final class o extends l implements k {
    private final b diG;
    private e diJ;
    public String hwU;
    public int hwV;
    public String hwW;

    public o(String str, int i, String str2, String str3, String str4, String str5, int i2, int i3, bqs bqs) {
        a aVar = new a();
        aVar.dIG = new aj();
        aVar.dIH = new ak();
        aVar.uri = "/cgi-bin/micromsg-bin/acceptcarditem";
        aVar.dIF = 651;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        aj ajVar = (aj) this.diG.dID.dIL;
        ajVar.cac = str;
        ajVar.hwf = str2;
        ajVar.cae = i;
        ajVar.cad = str3;
        ajVar.qZO = str4;
        ajVar.qZN = str5;
        ajVar.qZP = i2;
        ajVar.qZQ = i3;
        ajVar.qZR = bqs;
    }

    public final int getType() {
        return 651;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneAcceptCardItem", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        ak akVar;
        if (i2 == 0 && i3 == 0) {
            akVar = (ak) this.diG.dIE.dIL;
            if (akVar != null) {
                this.hwU = akVar.hwU;
                this.hwV = akVar.hwV;
                this.hwW = akVar.hwW;
            }
        } else {
            akVar = (ak) this.diG.dIE.dIL;
            if (akVar != null) {
                this.hwU = akVar.hwU;
                this.hwV = akVar.hwV;
                this.hwW = akVar.hwW;
            }
        }
        this.diJ.a(i2, i3, str, this);
    }
}
