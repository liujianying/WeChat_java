package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication.2;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiLaunchApplication.LaunchApplicationTask;
import com.tencent.mm.sdk.platformtools.x;

class GameJsApiLaunchApplication$2$2 implements Runnable {
    final /* synthetic */ 2 jHd;
    final /* synthetic */ LaunchApplicationTask jHe;

    GameJsApiLaunchApplication$2$2(2 2, LaunchApplicationTask launchApplicationTask) {
        this.jHd = 2;
        this.jHe = launchApplicationTask;
    }

    public final void run() {
        x.i("MicroMsg.GameJsApiLaunchApplication", "callback");
        if (this.jHe.success) {
            this.jHd.jGK.tp(a.f("launchApplication:ok", null));
        } else {
            this.jHd.jGK.tp(a.f("launchApplication:fail", null));
        }
    }
}
