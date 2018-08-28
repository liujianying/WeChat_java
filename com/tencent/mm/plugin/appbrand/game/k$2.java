package com.tencent.mm.plugin.appbrand.game;

class k$2 implements Runnable {
    final /* synthetic */ k fAo;

    k$2(k kVar) {
        this.fAo = kVar;
    }

    public final void run() {
        if (k.a(this.fAo) != null && !k.a(this.fAo).fzJ) {
            k.a(this.fAo).fzJ = true;
            this.fAo.agj();
        }
    }
}
