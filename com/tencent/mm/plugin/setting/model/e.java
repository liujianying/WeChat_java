package com.tencent.mm.plugin.setting.model;

import com.tencent.mm.ab.b.a;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aiq;
import com.tencent.mm.protocal.c.air;
import com.tencent.mm.sdk.platformtools.x;

public final class e extends l implements k {
    private com.tencent.mm.ab.e diJ;

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.dIZ = i;
        if (!(i2 == 0 && i3 == 0)) {
            x.e("MicroMsg.NetSceneGetTrustedFriends", "errType:%d, errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        }
        this.diJ.a(i2, i3, str, this);
    }

    public final int getType() {
        return 869;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        a aVar = new a();
        aVar.dIG = new aiq();
        aVar.dIH = new air();
        aVar.uri = "/cgi-bin/micromsg-bin/gettrustedfriends";
        aVar.dIF = 869;
        aVar.dII = 0;
        aVar.dIJ = 0;
        return a(eVar, aVar.KT(), this);
    }
}
