package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.ab.b;
import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.sdk.platformtools.x;

public final class p extends l implements k {
    private b diG;
    private e diJ;

    public final int getType() {
        return 980;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.diJ = eVar2;
        return a(eVar, this.diG, this);
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        x.d("MicroMsg.NetSceneAsyncBizSubscribe", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (this.diJ != null) {
            this.diJ.a(i2, i3, str, this);
        }
    }
}
