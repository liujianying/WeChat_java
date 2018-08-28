package com.tencent.mm.ui.appbrand;

class c$4 implements Runnable {
    final /* synthetic */ c tro;

    public c$4(c cVar) {
        this.tro = cVar;
    }

    public final void run() {
        this.tro.trn.sendEmptyMessage(0);
    }

    public final String toString() {
        return super.toString() + "MicroMsg.AppBrandServiceImageBubbleshow";
    }
}
