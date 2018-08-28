package com.tencent.f;

import com.tencent.f.b.a;
import com.tencent.f.b.b;
import com.tencent.f.b.d;

public final class g implements b {
    int mReferenceCount = 0;
    int mState;
    private f vwI;
    d vwJ;
    b vwK;
    a vwL;

    public g(f fVar, d dVar) {
        this.vwI = fVar;
        this.vwJ = dVar;
    }

    public final void start() {
        this.vwI.a(this);
    }
}
