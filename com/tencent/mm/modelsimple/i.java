package com.tencent.mm.modelsimple;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.x;

public final class i extends l implements k {
    private final q dJM = new com.tencent.mm.ab.k();
    private e diJ;

    public final int getType() {
        return 381;
    }

    public final boolean La() {
        return false;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.dJM, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneGetCert", "dkcert onGYNetEnd [%d,%d]", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.diJ.a(i2, i3, str, this);
    }
}
