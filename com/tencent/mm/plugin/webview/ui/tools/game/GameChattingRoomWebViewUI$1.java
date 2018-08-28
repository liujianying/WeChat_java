package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import com.tencent.mm.pluginsdk.ui.applet.q.a;

class GameChattingRoomWebViewUI$1 implements a {
    final /* synthetic */ GameChattingRoomWebViewUI qfJ;

    GameChattingRoomWebViewUI$1(GameChattingRoomWebViewUI gameChattingRoomWebViewUI) {
        this.qfJ = gameChattingRoomWebViewUI;
    }

    public final void a(boolean z, String str, int i) {
        this.qfJ.setResult(GameChattingRoomWebViewUI.a(this.qfJ), new Intent());
        this.qfJ.finish();
    }
}
