package com.tencent.mm.plugin.webview.ui.tools.game;

import android.webkit.ConsoleMessage;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

protected class GameWebViewUI$b extends h {
    final /* synthetic */ GameWebViewUI qgm;

    protected GameWebViewUI$b(GameWebViewUI gameWebViewUI) {
        this.qgm = gameWebViewUI;
        super(gameWebViewUI);
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String message = consoleMessage != null ? consoleMessage.message() : null;
        if (bi.oW(message) || !message.equalsIgnoreCase("weixin://whiteScreenEnd")) {
            return super.onConsoleMessage(consoleMessage);
        }
        x.d("MicroMsg.Wepkg.GameWebViewUI", "whiteScreenEnd");
        this.qgm.qgh = true;
        return true;
    }
}
