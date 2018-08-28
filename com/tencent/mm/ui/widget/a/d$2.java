package com.tencent.mm.ui.widget.a;

import android.support.design.widget.BottomSheetBehavior.a;

class d$2 extends a {
    final /* synthetic */ d uKm;

    d$2(d dVar) {
        this.uKm = dVar;
    }

    public final void u(int i) {
    }

    public final void g(float f) {
        if (d.h(this.uKm) != null && !d.i(this.uKm)) {
            if (d.j(this.uKm).canScrollVertically(-1) && d.k(this.uKm) && f != 0.0f) {
                d.h(this.uKm).setVisibility(0);
            } else {
                d.h(this.uKm).setVisibility(4);
            }
        }
    }
}
