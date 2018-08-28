package com.tencent.mm.plugin.appbrand.ui.recents;

import android.view.View;
import com.tencent.mm.plugin.appbrand.ui.j;
import com.tencent.mm.plugin.appbrand.ui.recents.a.b;

class a$b$1 implements Runnable {
    final /* synthetic */ boolean gzc;
    final /* synthetic */ b gzd;

    a$b$1(b bVar, boolean z) {
        this.gzd = bVar;
        this.gzc = z;
    }

    public final void run() {
        int i = 0;
        if (!(a.b(this.gzd.gyS).isEmpty() || a.b(this.gzd.gyS) == null)) {
            a.b(this.gzd.gyS).bl(a.b(this.gzd.gyS).getItemCount() - 1);
        }
        if (a.m(this.gzd.gyS) != null) {
            int i2;
            b m = a.m(this.gzd.gyS);
            if (this.gzc || a.b(this.gzd.gyS).isEmpty()) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            View view = m.gzq;
            if (i2 == 0) {
                i = 4;
            }
            j.s(view, i);
        }
    }
}
