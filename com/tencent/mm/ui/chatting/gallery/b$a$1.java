package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.ui.chatting.gallery.b.a;

class b$a$1 implements Runnable {
    final /* synthetic */ long tTX;
    final /* synthetic */ Boolean tTY;
    final /* synthetic */ b tTZ;
    final /* synthetic */ a tUa;

    b$a$1(a aVar, long j, Boolean bool, b bVar) {
        this.tUa = aVar;
        this.tTX = j;
        this.tTY = bool;
        this.tTZ = bVar;
    }

    public final void run() {
        a.a(this.tUa, this.tTX);
        if (this.tTY.booleanValue()) {
            this.tUa.handler.postDelayed(new 1(this), 0);
        }
    }
}
