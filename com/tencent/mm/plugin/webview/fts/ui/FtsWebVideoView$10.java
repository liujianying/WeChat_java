package com.tencent.mm.plugin.webview.fts.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class FtsWebVideoView$10 extends BroadcastReceiver {
    final /* synthetic */ FtsWebVideoView pQA;

    FtsWebVideoView$10(FtsWebVideoView ftsWebVideoView) {
        this.pQA = ftsWebVideoView;
    }

    public final void onReceive(Context context, Intent intent) {
        if (FtsWebVideoView.d(this.pQA).isPlaying()) {
            FtsWebVideoView.a(this.pQA, context);
        }
    }
}
