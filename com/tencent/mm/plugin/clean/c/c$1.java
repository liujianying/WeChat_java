package com.tencent.mm.plugin.clean.c;

import java.util.ArrayList;

class c$1 implements Runnable {
    final /* synthetic */ ArrayList hQZ;
    final /* synthetic */ c hRa;

    c$1(c cVar, ArrayList arrayList) {
        this.hRa = cVar;
        this.hQZ = arrayList;
    }

    public final void run() {
        c.f(this.hRa).a(c.a(this.hRa), c.b(this.hRa), c.c(this.hRa), this.hQZ, c.d(this.hRa), c.e(this.hRa));
    }
}
