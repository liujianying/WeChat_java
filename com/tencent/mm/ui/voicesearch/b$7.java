package com.tencent.mm.ui.voicesearch;

import com.tencent.mm.model.au;
import com.tencent.mm.plugin.messenger.a.f;

class b$7 implements Runnable {
    final /* synthetic */ b uFM;
    final /* synthetic */ String uFN;

    b$7(b bVar, String str) {
        this.uFM = bVar;
        this.uFN = str;
    }

    public final void run() {
        if (b.b(this.uFM).isHidden()) {
            b.b(this.uFM).Bl();
            if (b.c(this.uFM)) {
                au.DF().a(new f(this.uFN, 3), 0);
                b.d(this.uFM);
                return;
            }
            return;
        }
        b.b(this.uFM).Bk();
    }
}
