package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication.LaunchApplicationTask;
import com.tencent.mm.pluginsdk.model.app.g.a;

class GameJsApiLaunchApplication$LaunchApplicationTask$2 implements a {
    final /* synthetic */ GameProcessActivityTask.a jGc;
    final /* synthetic */ LaunchApplicationTask jHg;

    GameJsApiLaunchApplication$LaunchApplicationTask$2(LaunchApplicationTask launchApplicationTask, GameProcessActivityTask.a aVar) {
        this.jHg = launchApplicationTask;
        this.jGc = aVar;
    }

    public final void cI(boolean z) {
        this.jHg.success = true;
        this.jGc.ahz();
    }
}
