package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aa;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.d;

class g$121 implements Runnable {
    final /* synthetic */ i qiH;
    final /* synthetic */ g qiK;

    g$121(g gVar, i iVar) {
        this.qiK = gVar;
        this.qiH = iVar;
    }

    public final void run() {
        if (this.qiH.qkl.equals(aa.NAME)) {
            g.a(this.qiK, this.qiH, g.bYr());
        } else if (this.qiH.qkl.equals(d.NAME)) {
            g.b(this.qiK, this.qiH, g.bYr());
        }
    }
}
