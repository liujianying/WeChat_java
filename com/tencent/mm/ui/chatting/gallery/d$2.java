package com.tencent.mm.ui.chatting.gallery;

class d$2 implements Runnable {
    final /* synthetic */ int eKj;
    final /* synthetic */ d tUW;

    d$2(d dVar, int i) {
        this.tUW = dVar;
        this.eKj = i;
    }

    public final void run() {
        if (this.tUW.tTx != null && this.tUW.tTx.tTy != null) {
            this.tUW.tTx.tTy.FC(this.eKj);
        }
    }
}
