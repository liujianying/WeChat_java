package com.tencent.mm.plugin.webview.ui.tools.widget;

import com.tencent.mm.plugin.webview.ui.tools.widget.i.4;

class i$4$13 implements Runnable {
    final /* synthetic */ int qaq;
    final /* synthetic */ String qar;
    final /* synthetic */ 4 qkX;

    i$4$13(4 4, String str, int i) {
        this.qkX = 4;
        this.qar = str;
        this.qaq = i;
    }

    public final void run() {
        if (this.qkX.qkV.qfM != null) {
            this.qkX.qkV.qfM.cC(this.qar, this.qaq);
        }
    }
}
