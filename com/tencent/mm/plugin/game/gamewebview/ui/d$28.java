package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.sdk.platformtools.bi;

class d$28 implements Runnable {
    final /* synthetic */ d jJO;

    d$28(d dVar) {
        this.jJO = dVar;
    }

    public final void run() {
        e e = d.e(this.jJO);
        int K = d.K(this.jJO);
        String L = d.L(this.jJO);
        e.setBackgroundColor(K);
        if (bi.oV(L).equals("black")) {
            e.iDE.setTextColor(-16777216);
            e.hBu.setColorFilter(-16777216);
            e.jKd.setColorFilter(-16777216);
            return;
        }
        e.iDE.setTextColor(-1);
        e.hBu.clearColorFilter();
        e.jKd.clearColorFilter();
    }
}
