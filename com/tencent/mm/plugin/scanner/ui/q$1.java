package com.tencent.mm.plugin.scanner.ui;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.modelstat.o;

class q$1 implements a {
    final /* synthetic */ q mLI;

    q$1(q qVar) {
        this.mLI = qVar;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (!z) {
            return true;
        }
        q.a(this.mLI, f2);
        q.b(this.mLI, f);
        q.a(this.mLI, (int) d2);
        q.a(this.mLI, "");
        q.b(this.mLI, "");
        q.b(this.mLI, i);
        q.a(this.mLI);
        q.b(this.mLI);
        if (!q.c(this.mLI)) {
            q.d(this.mLI);
            o.a(2012, f, f2, (int) d2);
        }
        return false;
    }
}
