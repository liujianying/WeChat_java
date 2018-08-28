package com.tencent.mm.plugin.webview.ui.tools.widget;

import com.tencent.mm.plugin.webview.ui.tools.widget.i.4;

class i$4$17 implements Runnable {
    final /* synthetic */ int eNW;
    final /* synthetic */ String fQh;
    final /* synthetic */ 4 qkX;

    i$4$17(4 4, String str, int i) {
        this.qkX = 4;
        this.fQh = str;
        this.eNW = i;
    }

    public final void run() {
        if (this.qkX.qkV.qfM != null) {
            this.qkX.qkV.qfM.cG(this.fQh, this.eNW);
        }
    }
}
