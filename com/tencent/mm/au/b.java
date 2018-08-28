package com.tencent.mm.au;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.b.a;

public final class b {
    private static final b edK = new b();
    public long edJ;

    public b() {
        if (g.Eg().Dx()) {
            this.edJ = q.GK();
        } else {
            a.sFg.a(new 1(this));
        }
    }

    public static b Qu() {
        return edK;
    }
}
