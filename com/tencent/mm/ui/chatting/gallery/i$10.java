package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.modelvideo.t;

class i$10 implements Runnable {
    final /* synthetic */ String nnz;
    final /* synthetic */ int tTd;
    final /* synthetic */ i tWK;

    i$10(i iVar, String str, int i) {
        this.tWK = iVar;
        this.nnz = str;
        this.tTd = i;
    }

    public final void run() {
        t.W(this.nnz, this.tTd);
    }
}
