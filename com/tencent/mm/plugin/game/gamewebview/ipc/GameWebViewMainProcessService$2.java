package com.tencent.mm.plugin.game.gamewebview.ipc;

import android.os.Bundle;
import android.os.Message;
import com.tencent.mm.plugin.game.gamewebview.ipc.b.a;

class GameWebViewMainProcessService$2 extends a {
    final /* synthetic */ GameWebViewMainProcessService jGo;

    GameWebViewMainProcessService$2(GameWebViewMainProcessService gameWebViewMainProcessService) {
        this.jGo = gameWebViewMainProcessService;
    }

    public final void s(Bundle bundle) {
        Message obtain = Message.obtain();
        obtain.setData(bundle);
        GameWebViewMainProcessService.a(this.jGo).send(obtain);
    }

    public final void t(Bundle bundle) {
        GameWebViewMainProcessService.e(bundle, false).aai();
    }
}
