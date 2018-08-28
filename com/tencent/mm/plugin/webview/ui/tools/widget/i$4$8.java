package com.tencent.mm.plugin.webview.ui.tools.widget;

import com.tencent.mm.plugin.webview.stub.c;
import com.tencent.mm.plugin.webview.ui.tools.widget.i.4;
import com.tencent.mm.sdk.platformtools.x;

class i$4$8 implements Runnable {
    final /* synthetic */ c qad;
    final /* synthetic */ 4 qkX;

    i$4$8(4 4, c cVar) {
        this.qkX = 4;
        this.qad = cVar;
    }

    public final void run() {
        try {
            i.a(this.qkX.qkV, this.qad);
        } catch (Exception e) {
            x.e("MicroMsg.MMWebViewClient", e.getMessage());
        }
    }
}
