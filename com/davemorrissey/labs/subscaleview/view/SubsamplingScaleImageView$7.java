package com.davemorrissey.labs.subscaleview.view;

import com.tencent.mm.sdk.platformtools.x;

class SubsamplingScaleImageView$7 implements Runnable {
    final /* synthetic */ SubsamplingScaleImageView abb;

    SubsamplingScaleImageView$7(SubsamplingScaleImageView subsamplingScaleImageView) {
        this.abb = subsamplingScaleImageView;
    }

    public final void run() {
        if (!(SubsamplingScaleImageView.t(this.abb) == null || SubsamplingScaleImageView.t(this.abb).isRecycled())) {
            x.i(SubsamplingScaleImageView.hM(), "alvinluo rotateAndScale fullImageBitmap");
            SubsamplingScaleImageView.a(this.abb, SubsamplingScaleImageView.a(SubsamplingScaleImageView.t(this.abb), SubsamplingScaleImageView.s(this.abb)));
        }
        this.abb.post(new Runnable() {
            public final void run() {
                if (SubsamplingScaleImageView.u(SubsamplingScaleImageView$7.this.abb) != null) {
                    SubsamplingScaleImageView.u(SubsamplingScaleImageView$7.this.abb).f(SubsamplingScaleImageView.t(SubsamplingScaleImageView$7.this.abb));
                }
            }
        });
    }
}
