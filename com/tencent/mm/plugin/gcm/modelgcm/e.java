package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.network.q;
import com.tencent.mm.plugin.gcm.modelgcm.c.a;

public final class e extends l implements k {
    private q dJM;
    private com.tencent.mm.ab.e diJ = null;
    private String khr = null;
    private int uin = 0;

    public e(String str, int i) {
        this.khr = str;
        this.uin = i;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.ab.e eVar2) {
        this.diJ = eVar2;
        this.dJM = new a();
        ((a) this.dJM).uin = this.uin;
        ((a) this.dJM.KV()).khn.qZb = this.khr;
        return a(eVar, this.dJM, this);
    }

    public final int getType() {
        return 623;
    }

    public final void a(int i, int i2, int i3, String str, q qVar, byte[] bArr) {
        this.diJ.a(i2, i3, str, this);
    }
}
