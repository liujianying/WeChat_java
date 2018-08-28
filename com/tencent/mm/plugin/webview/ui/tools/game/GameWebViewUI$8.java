package com.tencent.mm.plugin.webview.ui.tools.game;

import com.tencent.mm.sdk.platformtools.x;

class GameWebViewUI$8 implements Runnable {
    final /* synthetic */ GameWebViewUI qgm;

    GameWebViewUI$8(GameWebViewUI gameWebViewUI) {
        this.qgm = gameWebViewUI;
    }

    public final void run() {
        if (GameWebViewUI.G(this.qgm) != null) {
            if (GameWebViewUI.B(this.qgm) != null) {
                GameWebViewUI.B(this.qgm).aVl();
            }
            x.i("MicroMsg.Wepkg.GameWebViewUI", "home page, reload url:%s from net", new Object[]{GameWebViewUI.H(this.qgm)});
            GameWebViewUI.I(this.qgm).stopLoading();
            GameWebViewUI.K(this.qgm).loadUrl(GameWebViewUI.J(this.qgm));
        }
    }
}
