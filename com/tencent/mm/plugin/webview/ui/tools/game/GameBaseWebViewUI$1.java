package com.tencent.mm.plugin.webview.ui.tools.game;

import android.os.Bundle;
import android.os.RemoteException;

class GameBaseWebViewUI$1 extends c {
    final /* synthetic */ GameBaseWebViewUI qfE;

    GameBaseWebViewUI$1(GameBaseWebViewUI gameBaseWebViewUI) {
        this.qfE = gameBaseWebViewUI;
    }

    protected final void A(Bundle bundle) {
        try {
            if (GameBaseWebViewUI.a(this.qfE) != null && bundle != null) {
                GameBaseWebViewUI.b(this.qfE).g(96, bundle);
            }
        } catch (RemoteException e) {
        }
    }
}
