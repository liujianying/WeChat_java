package com.tencent.mm.ui;

import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.ui.h.18;

class h$18$1 implements Runnable {
    final /* synthetic */ 18 tiU;

    h$18$1(18 18) {
        this.tiU = 18;
    }

    public final void run() {
        au.HU();
        c.DT().set(68377, "");
        if (h.a(this.tiU.tiG) != null) {
            h.a(this.tiU.tiG).notifyDataSetChanged();
        }
    }
}
