package com.tencent.mm.plugin.webview.ui.tools.game;

import com.tencent.mm.plugin.webview.ui.tools.game.a.3;

class a$3$3 implements Runnable {
    final /* synthetic */ String dEt;
    final /* synthetic */ int fdh;
    final /* synthetic */ 3 qfS;

    a$3$3(3 3, String str, int i) {
        this.qfS = 3;
        this.dEt = str;
        this.fdh = i;
    }

    public final void run() {
        if (this.dEt != null) {
            this.qfS.qfR.qfK.setMMTitle(this.dEt);
        }
        this.qfS.qfR.qfK.nS(this.fdh);
    }
}
