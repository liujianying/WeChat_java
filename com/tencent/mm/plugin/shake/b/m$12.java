package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.bi;

class m$12 implements Runnable {
    final /* synthetic */ m mXg;

    m$12(m mVar) {
        this.mXg = mVar;
    }

    public final void run() {
        if (au.HX()) {
            au.HU();
            bi.g(c.Gi(), "Sk", 604800000);
        }
    }

    public final String toString() {
        return super.toString() + "|onAccountPostReset";
    }
}
