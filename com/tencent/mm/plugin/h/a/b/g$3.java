package com.tencent.mm.plugin.h.a.b;

import com.tencent.mm.plugin.h.a.b.g.a;

class g$3 implements Runnable {
    final /* synthetic */ int eWY;
    final /* synthetic */ g hgL;

    g$3(g gVar, int i) {
        this.hgL = gVar;
        this.eWY = i;
    }

    public final void run() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < g.a(this.hgL).size()) {
                ((a) g.a(this.hgL).get(i2)).nb(this.eWY);
                i = i2 + 1;
            } else {
                return;
            }
        }
    }
}
