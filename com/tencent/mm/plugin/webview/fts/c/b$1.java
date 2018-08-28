package com.tencent.mm.plugin.webview.fts.c;

import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView;
import com.tencent.mm.sdk.platformtools.x;

class b$1 implements a {
    final /* synthetic */ FtsWebVideoView pQQ;
    final /* synthetic */ b pQR;

    b$1(b bVar, FtsWebVideoView ftsWebVideoView) {
        this.pQR = bVar;
        this.pQQ = ftsWebVideoView;
    }

    public final void ajd() {
        FtsWebVideoView ftsWebVideoView = this.pQQ;
        x.i("MicroMsg.FtsWebVideoView", "onExitFullScreen");
        if (ftsWebVideoView.pQg.gaY) {
            ftsWebVideoView.pQg.ajc();
        }
        ftsWebVideoView.cV(false);
    }
}
