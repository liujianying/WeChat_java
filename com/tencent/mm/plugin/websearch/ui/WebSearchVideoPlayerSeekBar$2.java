package com.tencent.mm.plugin.websearch.ui;

import android.view.View;
import android.view.View.OnLayoutChangeListener;

class WebSearchVideoPlayerSeekBar$2 implements OnLayoutChangeListener {
    final /* synthetic */ WebSearchVideoPlayerSeekBar pNj;

    WebSearchVideoPlayerSeekBar$2(WebSearchVideoPlayerSeekBar webSearchVideoPlayerSeekBar) {
        this.pNj = webSearchVideoPlayerSeekBar;
    }

    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (i3 - i != i7 - i5) {
            this.pNj.ajV();
        }
    }
}
