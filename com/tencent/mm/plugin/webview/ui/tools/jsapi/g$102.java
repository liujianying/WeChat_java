package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.sdk.platformtools.x;

class g$102 implements Runnable {
    final /* synthetic */ g qiK;

    g$102(g gVar) {
        this.qiK = gVar;
    }

    public final void run() {
        try {
            g.h(this.qiK, new i());
        } catch (Exception e) {
            x.i("MicroMsg.MsgHandler", "openCunstomWebview, close window exception : %s", new Object[]{e.getMessage()});
        }
    }
}
