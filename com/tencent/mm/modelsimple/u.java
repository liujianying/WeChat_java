package com.tencent.mm.modelsimple;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.apn;
import com.tencent.mm.protocal.c.apo;
import com.tencent.mm.sdk.platformtools.x;

public final class u extends l implements k {
    private final b dZf;
    private e diJ;
    public Object tag;

    public u(String str) {
        a aVar = new a();
        aVar.dIG = new apn();
        aVar.dIH = new apo();
        aVar.uri = "/cgi-bin/micromsg-bin/jumpemotiondetail";
        aVar.dIF = 666;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.dZf = aVar.KT();
        ((apn) this.dZf.dID.dIL).jPK = str;
    }

    public final int getType() {
        return 666;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.dZf, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneScanEmoji", "[oneliang][NetSceneScanEmoji]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            x.d("MicroMsg.NetSceneScanEmoji", "[oneliang][NetSceneScanEmoji]:net end ok");
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final apo Rt() {
        return (apo) this.dZf.dIE.dIL;
    }
}
