package com.tencent.mm.model;

import com.tencent.mm.protocal.c.byj;
import com.tencent.mm.protocal.k;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.e;

public class ba$b extends e implements c {
    public byj dBX = new byj();

    public final int G(byte[] bArr) {
        this.dBX = (byj) new byj().aG(bArr);
        k.a(this, this.dBX.six);
        return this.dBX.six.rfn;
    }

    public final int getCmdId() {
        return 0;
    }
}
