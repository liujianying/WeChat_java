package com.tencent.mm.plugin.webview.ui.tools.widget;

class i$1 implements Runnable {
    final /* synthetic */ i qkV;
    final /* synthetic */ String val$url;

    i$1(i iVar, String str) {
        this.qkV = iVar;
        this.val$url = str;
    }

    public final void run() {
        this.qkV.Do(this.val$url);
    }
}
