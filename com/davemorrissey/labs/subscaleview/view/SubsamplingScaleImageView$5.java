package com.davemorrissey.labs.subscaleview.view;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.x;

class SubsamplingScaleImageView$5 implements Runnable {
    final /* synthetic */ SubsamplingScaleImageView abb;
    final /* synthetic */ Bitmap abc;

    SubsamplingScaleImageView$5(SubsamplingScaleImageView subsamplingScaleImageView, Bitmap bitmap) {
        this.abb = subsamplingScaleImageView;
        this.abc = bitmap;
    }

    public final void run() {
        if (this.abc != null) {
            long currentTimeMillis = System.currentTimeMillis();
            SubsamplingScaleImageView.a(this.abb, SubsamplingScaleImageView.a(this.abc, SubsamplingScaleImageView.s(this.abb)));
            long currentTimeMillis2 = System.currentTimeMillis();
            x.i(SubsamplingScaleImageView.hM(), "alvinluo rotate and scale fullImageBitmap cost: %d", new Object[]{Long.valueOf(currentTimeMillis2 - currentTimeMillis)});
        }
    }
}
