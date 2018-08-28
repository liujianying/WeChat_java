package com.tencent.mm.plugin.product.ui;

import com.tencent.mm.sdk.platformtools.x;

public final class e {
    int lSC;
    int lSD;

    public e(int i, int i2) {
        this.lSD = i;
        this.lSC = i2;
    }

    public final boolean bne() {
        boolean z = (this.lSD & 1) > 0;
        x.d("MicroMsg.MallProductConfig", "isFreePost, ret = " + z);
        return z;
    }
}
