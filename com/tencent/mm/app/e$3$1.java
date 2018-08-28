package com.tencent.mm.app;

import com.tencent.mm.app.e.3;
import com.tencent.mm.kernel.b;

class e$3$1 implements Runnable {
    final /* synthetic */ int bym;
    final /* synthetic */ 3 byn;

    e$3$1(3 3, int i) {
        this.byn = 3;
        this.bym = i;
    }

    public final void run() {
        if (b.DD() != null) {
            b.DD().gW(this.bym);
        }
    }
}
