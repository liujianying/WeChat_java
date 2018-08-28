package com.tencent.mm.plugin.appbrand.ui.recents;

import com.tencent.mm.sdk.platformtools.bi;

class a$8 implements Runnable {
    final /* synthetic */ a gyS;
    final /* synthetic */ i gyY;

    a$8(a aVar, i iVar) {
        this.gyS = aVar;
        this.gyY = iVar;
    }

    public final void run() {
        if (!bi.cX(a.a(this.gyS))) {
            int size = a.a(this.gyS).size();
            a.a(this.gyS).clear();
            a.b(this.gyS).aa(0, size);
        }
        a.a(this.gyS).addAll(this.gyY);
        a.b(this.gyS).Z(0, this.gyY.size());
    }
}
