package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask.a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiSendAppMessage.SendAppMessageTask;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.widget.snackbar.a.c;

class GameJsApiSendAppMessage$SendAppMessageTask$1 implements c {
    final /* synthetic */ a jGc;
    final /* synthetic */ SendAppMessageTask jHx;

    GameJsApiSendAppMessage$SendAppMessageTask$1(SendAppMessageTask sendAppMessageTask, a aVar) {
        this.jHx = sendAppMessageTask;
        this.jGc = aVar;
    }

    public final void onShow() {
    }

    public final void onHide() {
        x.d("MicroMsg.GameJsApiSendAppMessage", "onHide");
        this.jGc.ahz();
    }

    public final void aSx() {
    }
}
