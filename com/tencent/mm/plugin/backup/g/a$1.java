package com.tencent.mm.plugin.backup.g;

class a$1 implements Runnable {
    final /* synthetic */ int bpX;
    final /* synthetic */ Object gYA;
    final /* synthetic */ a gYB;

    a$1(a aVar, int i, Object obj) {
        this.gYB = aVar;
        this.bpX = i;
        this.gYA = obj;
    }

    public final void run() {
        this.gYB.gYz.add(new a$a(this.gYB, this.bpX, this.gYA));
    }
}
