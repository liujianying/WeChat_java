package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.akv;
import com.tencent.mm.protocal.c.akw;
import com.tencent.mm.sdk.platformtools.x;

public final class af extends l implements k {
    public String cad;
    private final b diG;
    private e diJ;
    public int hwV;
    public String hwW;

    public af(String str, String str2, int i) {
        a aVar = new a();
        aVar.dIG = new akv();
        aVar.dIH = new akw();
        aVar.uri = "/cgi-bin/micromsg-bin/giftcarditem";
        aVar.dIF = 652;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        akv akv = (akv) this.diG.dID.dIL;
        akv.cac = str;
        akv.rNK = str2;
        akv.rNL = i;
    }

    public final int getType() {
        return 652;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGiftCardItem", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        akw akw;
        if (i2 == 0 && i3 == 0) {
            akw = (akw) this.diG.dIE.dIL;
            if (akw != null) {
                this.cad = akw.cad;
                this.hwW = akw.hwW;
                this.hwV = akw.hwV;
            }
        } else {
            akw = (akw) this.diG.dIE.dIL;
            if (akw != null) {
                this.cad = akw.cad;
                this.hwW = akw.hwW;
                this.hwV = akw.hwV;
            }
        }
        this.diJ.a(i2, i3, str, this);
    }
}
