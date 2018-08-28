package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.RelativeLayout.LayoutParams;

class d$1 implements OnPreDrawListener {
    final /* synthetic */ View qft;
    final /* synthetic */ d qfx;

    d$1(d dVar, View view) {
        this.qfx = dVar;
        this.qft = view;
    }

    public final boolean onPreDraw() {
        this.qft.getViewTreeObserver().removeOnPreDrawListener(this);
        LayoutParams layoutParams = (LayoutParams) this.qft.getLayoutParams();
        this.qfx.qeW = layoutParams.leftMargin - this.qfx.lvk;
        return true;
    }
}
