package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.abj;
import com.tencent.mm.protocal.c.abk;
import com.tencent.mm.protocal.c.bqs;
import com.tencent.mm.sdk.platformtools.x;

public final class aa extends l implements k {
    private final b diG;
    private e diJ;
    public String hwU;

    public aa(String str, int i, String str2, String str3, String str4, String str5, int i2, String str6, bqs bqs) {
        a aVar = new a();
        aVar.dIG = new abj();
        aVar.dIH = new abk();
        aVar.uri = "/cgi-bin/micromsg-bin/getcarditeminfo";
        aVar.dIF = 645;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        abj abj = (abj) this.diG.dID.dIL;
        abj.cac = str;
        abj.cae = i;
        abj.hwf = str2;
        abj.cad = str3;
        abj.qZO = str4;
        abj.qZN = str5;
        abj.qZP = i2;
        abj.rGk = str6;
        abj.qZR = bqs;
    }

    public final int getType() {
        return 645;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetCardItemInfo", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            this.hwU = ((abk) this.diG.dIE.dIL).hwU;
        }
        this.diJ.a(i2, i3, str, this);
    }
}
