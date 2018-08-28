package com.tencent.mm.plugin.soter.b;

import com.tencent.mm.protocal.c.bvg;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.e;

public class c$b extends e implements c {
    public bvg onw = new bvg();

    public final int G(byte[] bArr) {
        this.onw = (bvg) new bvg().aG(bArr);
        k.a(this, this.onw.six);
        return this.onw.six.rfn;
    }

    public final int getCmdId() {
        return 0;
    }
}
