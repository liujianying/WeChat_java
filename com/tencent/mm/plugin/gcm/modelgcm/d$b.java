package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.mm.protocal.c.co;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.e;

public class d$b extends e implements c {
    public co khq = new co();

    public final int G(byte[] bArr) {
        this.khq = (co) new co().aG(bArr);
        k.a(this, this.khq.six);
        return this.khq.six.rfn;
    }

    public final int getCmdId() {
        return 1000000241;
    }
}
