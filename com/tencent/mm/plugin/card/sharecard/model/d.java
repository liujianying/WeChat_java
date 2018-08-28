package com.tencent.mm.plugin.card.sharecard.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ahs;
import com.tencent.mm.protocal.c.aht;
import com.tencent.mm.sdk.platformtools.x;

public final class d extends l implements k {
    private final b diG;
    private e diJ;
    public String hwU;
    public int hwV;
    public String hwW;

    public d(String str, String str2, String str3) {
        a aVar = new a();
        aVar.dIG = new ahs();
        aVar.dIH = new aht();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/getsharecardconsumedinfo";
        aVar.dIF = 910;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ahs ahs = (ahs) this.diG.dID.dIL;
        ahs.cac = str;
        ahs.scene = 20;
        ahs.huU = str2;
        ahs.code = str3;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetShareCardConsumedInfo", "onGYNetEnd, cmdType = %d, errType = %d, errCode = %d", new Object[]{Integer.valueOf(910), Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            aht aht = (aht) this.diG.dIE.dIL;
            x.v("MicroMsg.NetSceneGetShareCardConsumedInfo", "json:" + aht.hwU);
            this.hwU = aht.hwU;
            this.hwW = aht.hwW;
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 910;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
