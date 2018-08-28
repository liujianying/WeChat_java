package com.tencent.mm.plugin.h.a.c;

class a$2 implements Runnable {
    final /* synthetic */ a hiK;

    a$2(a aVar) {
        this.hiK = aVar;
    }

    public final void run() {
        if (a.b(this.hiK).isDiscovering()) {
            a.b(this.hiK).cancelDiscovery();
        }
    }
}
