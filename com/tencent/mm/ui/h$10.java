package com.tencent.mm.ui;

import com.tencent.mm.g.a.me;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ah;

class h$10 implements Runnable {
    final /* synthetic */ h tiG;

    h$10(h hVar) {
        this.tiG = hVar;
    }

    public final void run() {
        final me meVar = new me();
        a.sFg.m(meVar);
        ah.A(new Runnable() {
            public final void run() {
                h.a(h$10.this.tiG, meVar);
            }
        });
    }
}
