package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Intent;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.ui.MMActivity.a;

class ay$1 implements a {
    final /* synthetic */ int doP;
    final /* synthetic */ d jGF;
    final /* synthetic */ ay jHz;

    ay$1(ay ayVar, d dVar, int i) {
        this.jHz = ayVar;
        this.jGF = dVar;
        this.doP = i;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i != 2) {
            return;
        }
        if (i2 == -1) {
            this.jGF.E(this.doP, com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("share_timeline:ok", null));
        } else {
            this.jGF.E(this.doP, com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("share_timeline:cancel", null));
        }
    }
}
