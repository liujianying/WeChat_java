package com.tencent.mm.plugin.webview.ui.tools.game;

import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.webview.ui.tools.game.menu.b.b;
import com.tencent.mm.ui.base.l;

class GameWebViewUI$3 implements b {
    final /* synthetic */ GameWebViewUI qgm;

    GameWebViewUI$3(GameWebViewUI gameWebViewUI) {
        this.qgm = gameWebViewUI;
    }

    public final void a(l lVar) {
        h.mEJ.a(480, 0, 1, false);
        l y = GameWebViewUI.y(this.qgm);
        if (y != null) {
            lVar.twb.addAll(y.twb);
        }
    }
}
