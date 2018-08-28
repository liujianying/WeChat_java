package com.tencent.mm.plugin.topstory.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.c.bte;

class d$1 implements Runnable {
    final /* synthetic */ bte ozt;

    d$1(bte bte) {
        this.ozt = bte;
    }

    public final void run() {
        ((a) g.n(a.class)).getWebViewMgr().a(this.ozt);
    }
}
