package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.view.View;
import android.view.ViewParent;

class MCanvasView$1 implements Runnable {
    final /* synthetic */ MCanvasView fnF;

    MCanvasView$1(MCanvasView mCanvasView) {
        this.fnF = mCanvasView;
    }

    public final void run() {
        ViewParent parent = this.fnF.getParent();
        do {
            ((View) parent).forceLayout();
            parent = parent.getParent();
        } while (parent instanceof View);
        if (parent != null) {
            parent.requestLayout();
            this.fnF.invalidate();
        }
    }
}
