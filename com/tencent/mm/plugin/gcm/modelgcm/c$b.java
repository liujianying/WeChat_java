package com.tencent.mm.plugin.gcm.modelgcm;

import com.tencent.mm.protocal.c.cm;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.e;

public class c$b extends e implements c {
    public cm kho = new cm();

    public final int G(byte[] bArr) {
        this.kho = (cm) new cm().aG(bArr);
        k.a(this, this.kho.six);
        return this.kho.six.rfn;
    }

    public final int getCmdId() {
        return 1000000289;
    }
}
