package com.tencent.mm.plugin.appbrand.game.b;

import com.tencent.magicbrush.a.d.a;
import com.tencent.mm.plugin.report.service.h;

final class b$a implements a {
    private int fAT;

    public b$a() {
        this.fAT = -1;
        this.fAT = 14883;
    }

    public final void c(Object... objArr) {
        if (this.fAT != -1) {
            h.mEJ.h(this.fAT, objArr);
        }
    }
}
