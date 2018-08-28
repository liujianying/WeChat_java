package com.tencent.mm.plugin.webview.ui.tools.widget;

import com.tencent.mm.plugin.webview.ui.tools.widget.i.4;

class i$4$12 implements Runnable {
    final /* synthetic */ String bAj;
    final /* synthetic */ int fdk;
    final /* synthetic */ long qaj;
    final /* synthetic */ 4 qkX;

    i$4$12(4 4, String str, long j, int i) {
        this.qkX = 4;
        this.bAj = str;
        this.qaj = j;
        this.fdk = i;
    }

    public final void run() {
        if (this.qkX.qkV.qfM != null && this.qkX.qkV.qhr != null && this.qkX.qkV.qhr.bVR() != null && this.qkX.qkV.qhr.bVR().gu(42)) {
            this.qkX.qkV.qfM.g(this.bAj, this.qaj, this.fdk);
        }
    }
}
