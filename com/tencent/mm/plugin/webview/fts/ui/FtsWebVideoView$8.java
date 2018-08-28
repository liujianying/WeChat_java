package com.tencent.mm.plugin.webview.fts.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.webview.fts.ui.FtsWebVideoView.c;

class FtsWebVideoView$8 implements OnClickListener {
    final /* synthetic */ FtsWebVideoView pQA;

    FtsWebVideoView$8(FtsWebVideoView ftsWebVideoView) {
        this.pQA = ftsWebVideoView;
    }

    public final void onClick(View view) {
        if (FtsWebVideoView.a(this.pQA) == c.pQG) {
            FtsWebVideoView.b(this.pQA);
        }
        this.pQA.jS(true);
    }
}
