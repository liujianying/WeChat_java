package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.View;

class a$2 implements Runnable {
    final /* synthetic */ a qfn;
    final /* synthetic */ View qfo;

    a$2(a aVar, View view) {
        this.qfn = aVar;
        this.qfo = view;
    }

    public final void run() {
        this.qfn.qeU = this.qfo.getMeasuredHeight();
    }
}
