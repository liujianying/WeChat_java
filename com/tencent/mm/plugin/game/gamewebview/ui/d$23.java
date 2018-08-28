package com.tencent.mm.plugin.game.gamewebview.ui;

import com.tencent.mm.sdk.platformtools.bi;

class d$23 implements Runnable {
    final /* synthetic */ String dEt;
    final /* synthetic */ int fdh;
    final /* synthetic */ d jJO;

    public d$23(d dVar, String str, int i) {
        this.jJO = dVar;
        this.dEt = str;
        this.fdh = i;
    }

    public final void run() {
        if (d.e(this.jJO) != null) {
            if (!bi.oW(this.dEt)) {
                d.e(this.jJO).setTitleText(this.dEt);
            }
            d.e(this.jJO).setTitleColor(this.fdh);
        }
    }
}
