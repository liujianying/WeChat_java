package com.tencent.mm.plugin.talkroom.model;

class g$4 implements Runnable {
    final /* synthetic */ int hbj;
    final /* synthetic */ g oxj;

    g$4(g gVar, int i) {
        this.oxj = gVar;
        this.hbj = i;
    }

    public final void run() {
        g.a(this.oxj, this.hbj - 1);
    }
}
