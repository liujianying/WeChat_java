package com.tencent.mm.vending.b;

import com.tencent.mm.vending.e.a;
import com.tencent.mm.vending.h.d;
import junit.framework.Assert;

public final class b<_Callback> implements a {
    public d byz;
    private int mPriority = -1;
    private a uQA;
    public _Callback uQB;
    private int uQC;

    public final b<_Callback> a(com.tencent.mm.vending.e.b bVar) {
        Assert.assertNotNull(bVar);
        bVar.keep(this);
        return this;
    }

    public b(_Callback _callback, a aVar) {
        Assert.assertNotNull("Callback should not be null!", _callback);
        this.uQC = _callback.hashCode();
        this.uQB = _callback;
        this.uQA = aVar;
    }

    public final int hashCode() {
        return this.uQC;
    }

    public final boolean equals(Object obj) {
        return obj != null && obj.hashCode() == this.uQC;
    }

    public final void dead() {
        Assert.assertNotNull(this.uQA);
        this.uQA.b(this);
    }
}
