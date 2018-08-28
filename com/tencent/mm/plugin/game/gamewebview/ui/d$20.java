package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.sdk.platformtools.bi;

class d$20 implements Runnable {
    final /* synthetic */ d jJO;
    final /* synthetic */ String jJT;
    final /* synthetic */ int jJU;

    public d$20(d dVar, String str, int i) {
        this.jJO = dVar;
        this.jJT = str;
        this.jJU = i;
    }

    public final void run() {
        if (!bi.oW(this.jJT)) {
            d.E(this.jJO).setText(this.jJT);
        }
        if (this.jJU >= 0) {
            d.E(this.jJO).setMaxCount(this.jJU);
        }
        d.E(this.jJO).show();
    }
}
