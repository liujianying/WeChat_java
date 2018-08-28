package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.View;
import android.view.ViewTreeObserver.OnPreDrawListener;

class d$2 implements OnPreDrawListener {
    final /* synthetic */ View qfv;
    final /* synthetic */ d qfx;

    d$2(d dVar, View view) {
        this.qfx = dVar;
        this.qfv = view;
    }

    public final boolean onPreDraw() {
        this.qfv.getViewTreeObserver().removeOnPreDrawListener(this);
        this.qfx.qeV = 0;
        return true;
    }
}
