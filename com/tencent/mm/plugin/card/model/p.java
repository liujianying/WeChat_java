package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.al;
import com.tencent.mm.protocal.c.am;
import com.tencent.mm.protocal.c.ky;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

public final class p extends l implements k {
    private final b diG;
    private e diJ;
    public String hwU;
    public int hwV;
    public String hwW;

    public p(LinkedList<ky> linkedList, int i, String str, String str2, int i2) {
        a aVar = new a();
        aVar.dIG = new al();
        aVar.dIH = new am();
        aVar.uri = "/cgi-bin/micromsg-bin/acceptcardlistfromapp";
        aVar.dIF = 687;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        al alVar = (al) this.diG.dID.dIL;
        alVar.qZS = linkedList;
        alVar.cae = i;
        alVar.qZO = str;
        alVar.qZN = str2;
        alVar.qZP = i2;
    }

    public final int getType() {
        return 687;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            am amVar = (am) this.diG.dIE.dIL;
            this.hwU = amVar.hwU;
            this.hwV = amVar.hwV;
            this.hwW = amVar.hwW;
            x.e("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, ret_code = " + this.hwV + " ret_msg = " + this.hwW);
        }
        this.diJ.a(i2, i3, str, this);
    }
}
