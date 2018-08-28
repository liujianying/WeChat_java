package com.tencent.mm.plugin.webview.ui.tools.widget;

import com.tencent.mm.plugin.webview.ui.tools.widget.i.4;
import java.util.Map;

class i$4$2 implements Runnable {
    final /* synthetic */ Map pZO;
    final /* synthetic */ 4 qkX;

    i$4$2(4 4, Map map) {
        this.qkX = 4;
        this.pZO = map;
    }

    public final void run() {
        if (this.qkX.qkV.qfM != null) {
            this.qkX.qkV.qfM.an(this.pZO);
        }
    }
}
