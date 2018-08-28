package com.tencent.mm.pluginsdk.model;

class k$1 implements Runnable {
    final /* synthetic */ Object[] nnG;
    final /* synthetic */ k qyW;

    k$1(k kVar, Object[] objArr) {
        this.qyW = kVar;
        this.nnG = objArr;
    }

    public final void run() {
        this.qyW.handler.post(new 1(this, this.qyW.bxI()));
    }
}
