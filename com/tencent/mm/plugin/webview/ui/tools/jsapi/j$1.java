package com.tencent.mm.plugin.webview.ui.tools.jsapi;

class j$1 implements Runnable {
    final /* synthetic */ j qkw;

    j$1(j jVar) {
        this.qkw = jVar;
    }

    public final void run() {
        if (this.qkw.qku != null && this.qkw.dMm != null) {
            this.qkw.kHU.a(this.qkw.qks);
            this.qkw.dMm.c(this.qkw.qku);
            this.qkw.qku.a(false, 0.0f, 0.0f, 0, 0.0d, 0.0d, 0.0d);
        }
    }
}
