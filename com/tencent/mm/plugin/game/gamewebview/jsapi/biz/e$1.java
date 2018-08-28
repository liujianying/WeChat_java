package com.tencent.mm.plugin.game.gamewebview.jsapi.biz;

import android.content.Intent;
import com.tencent.mm.plugin.game.gamewebview.ui.d;
import com.tencent.mm.ui.MMActivity.a;

class e$1 implements a {
    final /* synthetic */ int doP;
    final /* synthetic */ d jGF;
    final /* synthetic */ e jGQ;

    e$1(e eVar, d dVar, int i) {
        this.jGQ = eVar;
        this.jGF = dVar;
        this.doP = i;
    }

    public final void b(int i, int i2, Intent intent) {
        if (i != (this.jGQ.hashCode() & 65535)) {
            return;
        }
        if (i2 == -1) {
            this.jGF.E(this.doP, com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("batch_view_card:ok", null));
        } else {
            this.jGF.E(this.doP, com.tencent.mm.plugin.game.gamewebview.jsapi.a.f("batch_view_card:fail", null));
        }
    }
}
