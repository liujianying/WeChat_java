package com.tencent.mm.plugin.wenote.model.nativenote.manager;

import com.tencent.mm.sdk.platformtools.al.a;

class k$2 implements a {
    final /* synthetic */ k qrG;

    k$2(k kVar) {
        this.qrG = kVar;
    }

    public final boolean vD() {
        if (-1 == k.c(this.qrG)) {
            return false;
        }
        this.qrG.cal();
        return true;
    }
}
