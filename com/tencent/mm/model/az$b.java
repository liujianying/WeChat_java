package com.tencent.mm.model;

import com.tencent.mm.protocal.c.ajs;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.e;

public class az$b extends e implements c {
    public ajs dBV = new ajs();

    public final int G(byte[] bArr) {
        this.dBV = (ajs) new ajs().aG(bArr);
        k.a(this, this.dBV.six);
        return this.dBV.six.rfn;
    }

    public final int getCmdId() {
        return 0;
    }
}
