package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.g.a.ir;
import com.tencent.mm.plugin.game.gamewebview.ipc.GameProcessActivityTask;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication.LaunchApplicationTask;
import com.tencent.mm.pluginsdk.model.app.g.a;

class GameJsApiLaunchApplication$LaunchApplicationTask$1 implements a {
    final /* synthetic */ GameProcessActivityTask.a jGc;
    final /* synthetic */ ir jHf;
    final /* synthetic */ LaunchApplicationTask jHg;

    GameJsApiLaunchApplication$LaunchApplicationTask$1(LaunchApplicationTask launchApplicationTask, ir irVar, GameProcessActivityTask.a aVar) {
        this.jHg = launchApplicationTask;
        this.jHf = irVar;
        this.jGc = aVar;
    }

    public final void cI(boolean z) {
        if (this.jHf.bSf.bSi || z) {
            this.jHg.success = true;
            this.jGc.ahz();
        }
    }
}
