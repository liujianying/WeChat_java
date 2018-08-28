package com.tencent.mm.protocal;

import com.tencent.mm.protocal.c.gu;
import com.tencent.mm.protocal.k.c;
import com.tencent.mm.protocal.k.e;
import com.tencent.mm.sdk.platformtools.x;

public class l$b extends e implements c {
    public gu qWF = new gu();

    public final int G(byte[] bArr) {
        this.qWF = (gu) new gu().aG(bArr);
        x.d("MicroMsg.MMBgFg", "retcode:" + this.qWF.hUm);
        return this.qWF.hUm;
    }

    public final int getCmdId() {
        return 1000000312;
    }

    public final boolean cgo() {
        return true;
    }
}
