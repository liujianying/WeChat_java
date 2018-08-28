package com.tencent.mm.plugin.webview.fts.ui;

import android.content.Context;

class FtsWebVideoView$11 implements Runnable {
    final /* synthetic */ FtsWebVideoView pQA;
    final /* synthetic */ Context val$context;

    FtsWebVideoView$11(FtsWebVideoView ftsWebVideoView, Context context) {
        this.pQA = ftsWebVideoView;
        this.val$context = context;
    }

    public final void run() {
        FtsWebVideoView.b(this.pQA, this.val$context);
    }
}
