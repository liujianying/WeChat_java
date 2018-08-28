package com.tencent.mm.plugin.webview.ui.tools.game;

import android.content.Intent;
import com.tencent.mm.pluginsdk.ui.applet.q.a;

class GameChattingRoomWebViewUI$2 implements a {
    final /* synthetic */ GameChattingRoomWebViewUI qfJ;

    GameChattingRoomWebViewUI$2(GameChattingRoomWebViewUI gameChattingRoomWebViewUI) {
        this.qfJ = gameChattingRoomWebViewUI;
    }

    public final void a(boolean z, String str, int i) {
        Intent intent = new Intent();
        intent.putExtra("rawUrl", GameChattingRoomWebViewUI.b(this.qfJ));
        this.qfJ.setResult(GameChattingRoomWebViewUI.c(this.qfJ), intent);
        this.qfJ.finish();
    }
}
