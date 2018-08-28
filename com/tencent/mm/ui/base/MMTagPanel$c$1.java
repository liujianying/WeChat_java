package com.tencent.mm.ui.base;

import com.tencent.mm.ui.base.MMTagPanel.c;
import com.tencent.mm.ui.tools.g;

class MMTagPanel$c$1 implements Runnable {
    final /* synthetic */ c tyc;

    MMTagPanel$c$1(c cVar) {
        this.tyc = cVar;
    }

    public final void run() {
        MMTagPanel.e(this.tyc.txS).i(MMTagPanel.i(this.tyc.txS), g.be(c.a(this.tyc), ""));
    }
}
