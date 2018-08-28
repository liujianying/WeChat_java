package com.tencent.mm.plugin.mall.a;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.age;
import com.tencent.mm.protocal.c.agf;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends l implements k {
    private e diJ;
    private com.tencent.mm.ab.b eAN;
    private age kYd;
    public agf kYe;

    public b() {
        a aVar = new a();
        aVar.dIG = new age();
        aVar.dIH = new agf();
        aVar.dIF = 1754;
        aVar.uri = "/cgi-bin/mmpay-bin/tenpay/getpaymenu";
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.eAN = aVar.KT();
        this.kYd = (age) this.eAN.dID.dIL;
    }

    public final int getType() {
        return 1754;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetSceneGetPayMenu", "doScene");
        this.diJ = eVar2;
        return a(eVar, this.eAN, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneGetPayMenu", "onGYNetEnd, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            int size;
            this.kYe = (agf) this.eAN.dIE.dIL;
            String str2 = "MicroMsg.NetSceneGetPayMenu";
            String str3 = "onGYNetEnd, title: %s, sectors: %s, sectors.size: %s";
            Object[] objArr = new Object[3];
            objArr[0] = this.kYe.title;
            objArr[1] = this.kYe.rJS;
            if (this.kYe.rJS != null) {
                size = this.kYe.rJS.size();
            } else {
                size = 0;
            }
            objArr[2] = Integer.valueOf(size);
            x.i(str2, str3, objArr);
        }
        this.diJ.a(i2, i3, str, this);
    }
}
