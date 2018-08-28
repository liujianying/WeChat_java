package com.tencent.mm.plugin.location.ui;

import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.sdk.platformtools.x;

class e$1 implements a {
    final /* synthetic */ e kEW;

    e$1(e eVar) {
        this.kEW = eVar;
    }

    public final boolean a(boolean z, float f, float f2, int i, double d, double d2, double d3) {
        if (!z) {
            return false;
        }
        if (e.a(this.kEW)) {
            return false;
        }
        x.d("MicroMsg.MyPoiPoint", "new location comes! slat : %f, slng: %f", new Object[]{Float.valueOf(f2), Float.valueOf(f)});
        e.b(this.kEW);
        e.a(this.kEW, d2);
        e.b(this.kEW, (double) f2);
        e.c(this.kEW, (double) f);
        if (e.c(this.kEW) != null) {
            if (e.d(this.kEW)) {
                e.c(this.kEW).updateLocaitonPinLayout(this.kEW, e.f(this.kEW), e.g(this.kEW));
            } else {
                e.e(this.kEW);
                e.c(this.kEW).addPinView(this.kEW, e.f(this.kEW), e.g(this.kEW));
            }
        }
        if (e.h(this.kEW) != null) {
            e.h(this.kEW).a(z, f, f2, i, d, d2, d3);
        }
        this.kEW.invalidate();
        this.kEW.postInvalidate();
        this.kEW.requestLayout();
        e.i(this.kEW);
        return true;
    }
}
