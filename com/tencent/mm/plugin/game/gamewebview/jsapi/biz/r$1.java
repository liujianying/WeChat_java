package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.GameJsApiMMTask.a;
import com.tencent.mm.plugin.game.wepkg.model.f;

class r$1 implements Runnable {
    final /* synthetic */ a jGI;
    final /* synthetic */ r jGY;

    r$1(r rVar, a aVar) {
        this.jGY = rVar;
        this.jGI = aVar;
    }

    public final void run() {
        f.a(new 1(this));
    }
}
