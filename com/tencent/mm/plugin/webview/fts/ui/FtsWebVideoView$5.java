package com.tencent.mm.plugin.webview.fts.ui;

import android.view.View;
import android.view.View.OnClickListener;

class FtsWebVideoView$5 implements OnClickListener {
    final /* synthetic */ FtsWebVideoView pQA;

    FtsWebVideoView$5(FtsWebVideoView ftsWebVideoView) {
        this.pQA = ftsWebVideoView;
    }

    public final void onClick(View view) {
        if (FtsWebVideoView.d(this.pQA).isPlaying()) {
            FtsWebVideoView.c(this.pQA).bTv();
            this.pQA.pause();
            return;
        }
        FtsWebVideoView.c(this.pQA).bTw();
        this.pQA.jS(true);
    }
}
