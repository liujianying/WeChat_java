package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.R;
import com.tencent.mm.ui.base.h;

class g$86 implements Runnable {
    final /* synthetic */ i qiH;
    final /* synthetic */ g qiK;

    g$86(g gVar, i iVar) {
        this.qiK = gVar;
        this.qiH = iVar;
    }

    public final void run() {
        h.a(g.j(this.qiK), g.j(this.qiK).getString(R.l.nfc_off_tips), "", g.j(this.qiK).getString(R.l.nfc_open_title), g.j(this.qiK).getString(R.l.app_cancel), new 1(this), new 2(this));
    }
}
