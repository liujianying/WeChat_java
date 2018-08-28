package com.tencent.mm.ac;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.c.aps;
import com.tencent.mm.sdk.platformtools.x;

public final class v extends l implements k {
    public String dMD;
    public b diG;
    private e diJ;

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.i("MicroMsg.NetSceneKFGetDefaultList", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 672;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        x.i("MicroMsg.NetSceneKFGetDefaultList", "do scene");
        return a(eVar, this.diG, this);
    }

    public final aps MU() {
        if (this.diG == null || this.diG.dIE.dIL == null) {
            return null;
        }
        return (aps) this.diG.dIE.dIL;
    }
}
