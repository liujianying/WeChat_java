package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.pluginsdk.model.app.g.a;

class GameJsApiLaunchApplication$1 implements a {
    final /* synthetic */ int doP;
    final /* synthetic */ d jGF;
    final /* synthetic */ GameJsApiLaunchApplication jHc;

    GameJsApiLaunchApplication$1(GameJsApiLaunchApplication gameJsApiLaunchApplication, d dVar, int i) {
        this.jHc = gameJsApiLaunchApplication;
        this.jGF = dVar;
        this.doP = i;
    }

    public final void cI(boolean z) {
        this.jGF.E(this.doP, com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("launchApplication:ok", null));
    }
}
