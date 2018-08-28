package com.tencent.mm.ui;

import com.tencent.mm.ui.z.a;

class z$a$1 implements Runnable {
    final /* synthetic */ int hW;
    final /* synthetic */ a tou;

    z$a$1(a aVar, int i) {
        this.tou = aVar;
        this.hW = i;
    }

    public final void run() {
        this.tou.too.eL(z.b(this.tou.too), z.c(this.tou.too));
        this.tou.too.DU(this.hW);
    }
}
