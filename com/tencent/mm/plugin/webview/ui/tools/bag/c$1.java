package com.tencent.mm.plugin.webview.ui.tools.bag;

import android.view.MotionEvent;
import com.tencent.mm.ui.widget.SwipeBackLayout.b;

class c$1 implements b {
    final /* synthetic */ c qbt;

    c$1(c cVar) {
        this.qbt = cVar;
    }

    public final void aw(float f) {
        float f2 = 1.0f;
        f fVar = this.qbt.qbr;
        if (f < 0.15f) {
            f2 = 0.0f;
        } else {
            float f3 = 2.0f * f;
            if (f3 <= 1.0f) {
                f2 = f3;
            }
        }
        fVar.ax(f2);
    }

    public final void G(MotionEvent motionEvent) {
        this.qbt.qbs = motionEvent.getRawX();
    }

    public final boolean ke(boolean z) {
        if (z) {
            this.qbt.qbr.ax(1.0f);
            this.qbt.qbr.b(this.qbt.qbs, 21);
            return true;
        }
        this.qbt.qbr.ax(0.0f);
        return false;
    }
}
