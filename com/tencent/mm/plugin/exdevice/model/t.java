package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.biu;
import com.tencent.mm.protocal.c.biv;
import com.tencent.mm.sdk.platformtools.x;

public final class t extends l implements k {
    private b diG = null;
    private e diJ = null;

    public t(String str, String str2, String str3) {
        a aVar = new a();
        aVar.dIG = new biu();
        aVar.dIH = new biv();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/searchbleharddevice";
        aVar.dIF = 1706;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        biu biu = (biu) this.diG.dID.dIL;
        biu.mac = str;
        if (str2 == null) {
            str2 = "";
        }
        biu.userName = str2;
        if (str3 == null) {
            str3 = "";
        }
        biu.category = str3;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.exdevice.NetSceneSearchBLEHardDevice", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1706;
    }

    public final biv aHa() {
        return (biv) this.diG.dIE.dIL;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }
}
