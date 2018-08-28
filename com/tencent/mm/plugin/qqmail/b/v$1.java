package com.tencent.mm.plugin.qqmail.b;

class v$1 implements Runnable {
    final /* synthetic */ int dVx = 100;
    final /* synthetic */ int fXs;
    final /* synthetic */ v mdU;

    v$1(v vVar, int i) {
        this.mdU = vVar;
        this.fXs = i;
    }

    public final void run() {
        this.mdU.mdH.ab(this.mdU.mck, this.fXs, this.dVx);
    }
}
