package com.tencent.mm.plugin.webview.fts.ui;

import com.tencent.mm.plugin.sight.decode.ui.b;
import com.tencent.mm.sdk.platformtools.x;

class FtsWebVideoView$4 implements b {
    final /* synthetic */ FtsWebVideoView pQA;

    FtsWebVideoView$4(FtsWebVideoView ftsWebVideoView) {
        this.pQA = ftsWebVideoView;
    }

    public final void ajO() {
        x.i("MicroMsg.FtsWebVideoView", "onSeekPre");
        FtsWebVideoView.c(this.pQA).bTv();
    }

    public final void kV(int i) {
        x.i("MicroMsg.FtsWebVideoView", "onSeekTo %d", new Object[]{Integer.valueOf(i)});
        this.pQA.C(i, false);
        FtsWebVideoView.c(this.pQA).bTw();
        if (FtsWebVideoView.h(this.pQA) != null) {
            FtsWebVideoView.h(this.pQA).bTU();
        }
    }
}
