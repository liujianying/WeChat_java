package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import com.tencent.mm.plugin.game.gamewebview.jsapi.a;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aa.1;
import com.tencent.mm.plugin.webview.ui.tools.widget.l;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class aa$1$1 implements Runnable {
    final /* synthetic */ LinkedList fyu;
    final /* synthetic */ String jGM;
    final /* synthetic */ String jGN;
    final /* synthetic */ String jHi;
    final /* synthetic */ 1 jHj;

    aa$1$1(1 1, String str, LinkedList linkedList, String str2, String str3) {
        this.jHj = 1;
        this.jHi = str;
        this.fyu = linkedList;
        this.jGM = str2;
        this.jGN = str3;
    }

    public final void run() {
        l lVar = new l(this.jHj.val$context);
        1 1 = new 1(this);
        if (this.fyu == null || this.fyu.size() <= 0) {
            x.e("MicroMsg.GameJsApiLogin", "scopeInfoList is empty!");
            this.jHj.jGK.tp(a.f("loginfail", null));
        } else if (!lVar.a(this.fyu, this.jGM, this.jGN, 1)) {
            this.jHj.jGK.tp(a.f("loginfail", null));
        }
    }
}
