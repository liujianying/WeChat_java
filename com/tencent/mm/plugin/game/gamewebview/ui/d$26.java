package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.R;
import com.tencent.mm.plugin.webview.ui.tools.d;

class d$26 implements Runnable {
    final /* synthetic */ String gnP;
    final /* synthetic */ d jJO;

    d$26(d dVar, String str) {
        this.jJO = dVar;
        this.gnP = str;
    }

    public final void run() {
        d.h(this.jJO).AH(d.aO(this.gnP, this.jJO.getResources().getColor(R.e.webview_logo_bg_color)));
        d.h(this.jJO).bVU();
    }
}
