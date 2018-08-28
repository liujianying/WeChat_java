package com.tencent.mm.plugin.account.friend.a;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.ha;
import com.tencent.mm.protocal.c.hb;
import com.tencent.mm.sdk.platformtools.x;

public final class w extends l implements k {
    public static int eKF = 0;
    public static int eKG = 1;
    public static int eKH = -85;
    private final b diG;
    private e diJ;
    private int eKI = -1;
    private String eKJ;
    private int eKK = 0;

    public w(int i, String str, int i2) {
        switch (1.eKL[i - 1]) {
            case 1:
                this.eKI = 1;
                break;
            case 2:
                this.eKI = 2;
                break;
        }
        this.eKJ = str;
        this.eKK = i2;
        a aVar = new a();
        aVar.dIG = new ha();
        aVar.dIH = new hb();
        aVar.uri = "/cgi-bin/micromsg-bin/bindgooglecontact";
        aVar.dIF = 487;
        aVar.dII = 0;
        aVar.dIJ = 0;
        this.diG = aVar.KT();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        x.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "doScene");
        this.diJ = eVar2;
        ha haVar = (ha) this.diG.dID.dIL;
        haVar.rfe = this.eKI;
        haVar.rhh = this.eKJ;
        haVar.rhi = this.eKK;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.diJ.a(i2, i3, str, this);
        } else {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 487;
    }
}
