package com.tencent.mm.plugin.webview.fts.ui;

import android.view.View;
import android.view.View.OnClickListener;

class FtsWebVideoView$1 implements OnClickListener {
    final /* synthetic */ FtsWebVideoView pQA;

    FtsWebVideoView$1(FtsWebVideoView ftsWebVideoView) {
        this.pQA = ftsWebVideoView;
    }

    public final void onClick(View view) {
        this.pQA.pause();
    }
}
