package com.tencent.pb.common.b;

class e$2 implements Runnable {
    final /* synthetic */ e vcj;
    final /* synthetic */ d vck;

    e$2(e eVar, d dVar) {
        this.vcj = eVar;
        this.vck = dVar;
    }

    public final void run() {
        e.a(this.vcj).remove(this.vck);
        this.vcj.a(2, -1, "doScene failed", this.vck);
    }
}
