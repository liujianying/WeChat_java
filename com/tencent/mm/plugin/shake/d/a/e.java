package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.ab.l;
import com.tencent.mm.network.k;
import com.tencent.mm.protocal.c.bhp;

public abstract class e extends l implements k {
    protected boolean mYF = false;
    long mYG = 0;

    public abstract bhp bvf();

    public e(long j) {
        this.mYG = j;
    }

    public final boolean bve() {
        return this.mYF;
    }
}
