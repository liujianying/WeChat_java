package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.protocal.c.bxp;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.e;

public class k$b extends e implements c {
    public bxp iMu = new bxp();

    public final int G(byte[] bArr) {
        this.iMu = (bxp) new bxp().aG(bArr);
        k.a(this, this.iMu.six);
        return this.iMu.six.rfn;
    }

    public final int getCmdId() {
        return 0;
    }
}
