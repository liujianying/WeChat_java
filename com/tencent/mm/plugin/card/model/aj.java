package com.tencent.mm.plugin.card.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.zn;
import com.tencent.mm.protocal.c.zo;
import com.tencent.mm.sdk.platformtools.x;

public final class aj extends l implements k {
    private final b diG;
    private e diJ;
    public String hwU;
    public com.tencent.mm.bk.b hxt;
    public boolean hxu;

    public aj(String str, int i, String str2, String str3, int i2, String str4, String str5, String str6, com.tencent.mm.bk.b bVar) {
        a aVar = new a();
        aVar.dIG = new zn();
        aVar.dIH = new zo();
        aVar.uri = "/cgi-bin/micromsg-bin/getavailablecard";
        aVar.dIF = 664;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        zn znVar = (zn) this.diG.dID.dIL;
        znVar.hva = str;
        znVar.hFj = i;
        znVar.hFk = str2;
        znVar.hFl = str3;
        znVar.time_stamp = i2;
        znVar.hFm = str4;
        znVar.huU = str5;
        znVar.hFn = str6;
        znVar.hxt = bVar;
        if ("INVOICE".equalsIgnoreCase(str6)) {
            znVar.rFt = 1;
        } else {
            znVar.rFt = 0;
        }
    }

    public final int getType() {
        return 664;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetsceneGetAvailableCard", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            zo zoVar = (zo) this.diG.dIE.dIL;
            this.hwU = zoVar.hwU;
            this.hxt = zoVar.hxt;
            this.hxu = zoVar.rFu != 0;
        }
        this.diJ.a(i2, i3, str, this);
    }
}
