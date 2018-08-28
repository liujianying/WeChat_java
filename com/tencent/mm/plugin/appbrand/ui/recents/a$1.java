package com.tencent.mm.plugin.appbrand.ui.recents;

class a$1 implements Runnable {
    final /* synthetic */ a gyS;

    a$1(a aVar) {
        this.gyS = aVar;
    }

    public final void run() {
        int size = a.a(this.gyS).size();
        if (size > 0) {
            a.a(this.gyS).clear();
            a.b(this.gyS).aa(0, size);
        }
        a.c(this.gyS);
    }
}
