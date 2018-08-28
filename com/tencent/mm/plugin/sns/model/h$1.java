package com.tencent.mm.plugin.sns.model;

class h$1 implements Runnable {
    final /* synthetic */ Object[] nnG;
    final /* synthetic */ h nnH;

    h$1(h hVar, Object[] objArr) {
        this.nnH = hVar;
        this.nnG = objArr;
    }

    public final void run() {
        this.nnH.handler.post(new 1(this, this.nnH.bxI()));
    }
}
