package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.sdk.platformtools.ad;

class GameDownloadView$2 implements Runnable {
    final /* synthetic */ GameDownloadView jXJ;

    GameDownloadView$2(GameDownloadView gameDownloadView) {
        this.jXJ = gameDownloadView;
    }

    public final void run() {
        GameDownloadView.b(this.jXJ).dC(ad.getContext());
        GameDownloadView.b(this.jXJ).aTT();
        GameDownloadView.a(this.jXJ);
    }
}
