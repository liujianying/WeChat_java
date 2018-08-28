package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.bgv;
import com.tencent.mm.protocal.c.bgw;
import com.tencent.mm.sdk.platformtools.x;

public final class ai extends l implements k {
    private final b diG;
    private e diJ;

    public ai(String str, byte[] bArr, float f, float f2, float f3, boolean z, boolean z2) {
        a aVar = new a();
        aVar.dIG = new bgv();
        aVar.dIH = new bgw();
        aVar.uri = "/cgi-bin/card/reportlotionorbluetoothinfo";
        aVar.dIF = 2574;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        bgv bgv = (bgv) this.diG.dID.dIL;
        bgv.cac = str;
        bgv.shG = com.tencent.mm.bk.b.bi(bArr);
        bgv.bUg = f;
        bgv.bSx = f2;
        bgv.shF = f3;
        bgv.shH = z;
        bgv.shI = z2;
    }

    public final int getType() {
        return 2574;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneReportLotionOrBluetoothInfo", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        this.diJ.a(i2, i3, str, this);
    }
}
