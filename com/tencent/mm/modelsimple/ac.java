package com.tencent.mm.modelsimple;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.arn;
import com.tencent.mm.protocal.c.aro;
import com.tencent.mm.sdk.platformtools.x;

public final class ac extends l implements k {
    private final b diG;
    private e diJ;

    public ac(int i) {
        a aVar = new a();
        aVar.dIG = new arn();
        aVar.dIH = new aro();
        aVar.uri = "/cgi-bin/micromsg-bin/logoutwebwx";
        aVar.dIF = 281;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
        ((arn) this.diG.dID.dIL).qZc = i;
    }

    public final int getType() {
        return 281;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.d("MicroMsg.NetSceneWebWXLogout", "doScene");
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        if (!(i2 == 0 && i3 == 0)) {
            x.d("MicroMsg.NetSceneWebWXLogout", "logout Error. ");
        }
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
