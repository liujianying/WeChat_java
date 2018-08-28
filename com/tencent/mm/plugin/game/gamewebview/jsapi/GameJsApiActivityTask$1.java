package com.tencent.mm.plugin.game.gamewebview.jsapi;

import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask.a;

class GameJsApiActivityTask$1 implements a {
    final /* synthetic */ GameProcessActivityTask.a jGc;
    final /* synthetic */ GameJsApiActivityTask jGv;

    GameJsApiActivityTask$1(GameJsApiActivityTask gameJsApiActivityTask, GameProcessActivityTask.a aVar) {
        this.jGv = gameJsApiActivityTask;
        this.jGc = aVar;
    }

    public final void tp(String str) {
        this.jGv.jGu = str;
        this.jGc.ahz();
    }
}
