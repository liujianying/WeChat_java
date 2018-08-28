package com.tencent.mm.ui.base;

import android.view.ViewGroup.LayoutParams;
import com.tencent.mm.bp.a;

class VerticalScrollBar$1 implements Runnable {
    final /* synthetic */ int kvd;
    final /* synthetic */ int kve;
    final /* synthetic */ VerticalScrollBar tBn;

    VerticalScrollBar$1(VerticalScrollBar verticalScrollBar, int i, int i2) {
        this.tBn = verticalScrollBar;
        this.kvd = i;
        this.kve = i2;
    }

    public final void run() {
        if (this.tBn.kuW.length > 0) {
            int measureText = ((int) VerticalScrollBar.a(this.tBn).measureText(this.tBn.kuW[this.tBn.kuW.length - 1])) + a.fromDPToPix(this.tBn.getContext(), 8);
            if (measureText > this.kvd) {
                LayoutParams layoutParams = this.tBn.getLayoutParams();
                layoutParams.width = measureText;
                layoutParams.height = this.kve;
                this.tBn.setLayoutParams(layoutParams);
            }
        }
    }
}
