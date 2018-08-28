package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask;
import com.tencent.mm.pluginsdk.model.app.g.a;

class y$2 implements a {
    final /* synthetic */ GameJsApiMMTask.a jGI;
    final /* synthetic */ y jHb;

    y$2(y yVar, GameJsApiMMTask.a aVar) {
        this.jHb = yVar;
        this.jGI = aVar;
    }

    public final void cI(boolean z) {
        this.jGI.tp(com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("launch_3rdApp:ok", null));
    }
}
