package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import com.tencent.mm.plugin.webview.ui.tools.WebViewUI.g;

class GameWebViewUI$a extends g {
    final /* synthetic */ GameWebViewUI qgm;

    private GameWebViewUI$a(GameWebViewUI gameWebViewUI) {
        this.qgm = gameWebViewUI;
        super(gameWebViewUI);
    }

    /* synthetic */ GameWebViewUI$a(GameWebViewUI gameWebViewUI, byte b) {
        this(gameWebViewUI);
    }

    public final Object onMiscCallBack(String str, Bundle bundle) {
        Object onMiscCallBack = GameWebViewUI.B(this.qgm).kdM.onMiscCallBack(str, bundle);
        return onMiscCallBack != null ? onMiscCallBack : super.onMiscCallBack(str, bundle);
    }
}
