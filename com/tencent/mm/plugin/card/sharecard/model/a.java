package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.protocal.c.rn;
import com.tencent.mm.protocal.c.ro;
import com.tencent.mm.sdk.platformtools.x;

public final class a extends l implements k {
    private String cac = "";
    private final b diG;
    private e diJ;
    public int hwV;

    public a(String str) {
        com.tencent.mm.ab.b.a aVar = new com.tencent.mm.ab.b.a();
        aVar.dIG = new rn();
        aVar.dIH = new ro();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/delsharecard";
        aVar.dIF = 1163;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ((rn) this.diG.dID.dIL).cac = str;
        this.cac = str;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneDelShareCard", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[]{Integer.valueOf(1163), Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            ro roVar = (ro) this.diG.dIE.dIL;
            x.i("MicroMsg.NetSceneDelShareCard", "ret_code:" + roVar.hwV);
            this.hwV = roVar.hwV;
            if (this.hwV == 0) {
                am.axq().xB(this.cac);
            }
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1163;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
