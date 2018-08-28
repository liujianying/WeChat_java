package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.g.a.cn;
import com.tencent.mm.sdk.platformtools.x;

class g$35 implements Runnable {
    final /* synthetic */ cn pBq;
    final /* synthetic */ i qiH;
    final /* synthetic */ g qiK;

    g$35(g gVar, cn cnVar, i iVar) {
        this.qiK = gVar;
        this.pBq = cnVar;
        this.qiH = iVar;
    }

    public final void run() {
        x.i("MicroMsg.MsgHandler", "run ecard jsapi check callback");
        if (this.pBq.bJS.retCode == 0) {
            g.a(this.qiK, this.qiH, "openECard:ok", null);
        } else {
            g.a(this.qiK, this.qiH, "openECard:fail", null);
        }
    }
}
