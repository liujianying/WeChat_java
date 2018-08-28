package com.tencent.mm.plugin.webview.ui.tools.game;

import com.tencent.mm.plugin.webview.ui.tools.game.menu.d;
import com.tencent.mm.sdk.platformtools.x;

class GameWebViewUI$5 implements Runnable {
    final /* synthetic */ d jKk;
    final /* synthetic */ GameWebViewUI qgm;

    GameWebViewUI$5(GameWebViewUI gameWebViewUI, d dVar) {
        this.qgm = gameWebViewUI;
        this.jKk = dVar;
    }

    public final void run() {
        if (this.qgm.isFinishing() || GameWebViewUI.A(this.qgm)) {
            x.i("MicroMsg.Wepkg.GameWebViewUI", "tryShow bottom sheet failed, the activity has been destroyed.");
        } else {
            this.jKk.bXO();
        }
    }
}
