package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.KeyboardLinearLayout.a;

class d$11 implements a {
    final /* synthetic */ d jJO;

    d$11(d dVar) {
        this.jJO = dVar;
    }

    public final void qN(int i) {
        x.i("MicroMsg.GameWebPageView", "onKeyBoardStateChange, state = " + i);
        d.a(this.jJO, d.H(this.jJO), i);
        if (i == -3 && d.E(this.jJO) != null && d.E(this.jJO).getVisibility() == 0) {
            d.E(this.jJO).bYB();
        }
    }
}
