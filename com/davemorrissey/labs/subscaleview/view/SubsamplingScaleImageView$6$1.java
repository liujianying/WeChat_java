package com.davemorrissey.labs.subscaleview.view;

import com.davemorrissey.labs.subscaleview.view.SubsamplingScaleImageView.6;

class SubsamplingScaleImageView$6$1 implements Runnable {
    final /* synthetic */ 6 abg;

    SubsamplingScaleImageView$6$1(6 6) {
        this.abg = 6;
    }

    public final void run() {
        if (this.abg.abe || this.abg.abf) {
            this.abg.abb.invalidate();
            this.abg.abb.requestLayout();
        }
    }
}
