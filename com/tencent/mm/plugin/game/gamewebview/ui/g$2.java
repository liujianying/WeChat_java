package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.b;
import com.tencent.mm.ui.base.l;

class g$2 implements b {
    final /* synthetic */ g jKj;

    g$2(g gVar) {
        this.jKj = gVar;
    }

    public final void a(l lVar) {
        h.mEJ.a(480, 0, 1, false);
        l b = g.b(this.jKj);
        if (b != null) {
            lVar.twb.addAll(b.twb);
        }
    }
}
