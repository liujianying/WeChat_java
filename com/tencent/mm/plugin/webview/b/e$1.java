package com.tencent.mm.plugin.webview.b;

class e$1 implements Runnable {
    final /* synthetic */ e pNB;

    public e$1(e eVar) {
        this.pNB = eVar;
    }

    public final void run() {
        String str = "WebViewHistory";
        this.pNB.fV(str, "delete from WebViewHistory where  timeStamp < " + ((System.currentTimeMillis() / 1000) - 604800));
        e.a(this.pNB);
    }
}
