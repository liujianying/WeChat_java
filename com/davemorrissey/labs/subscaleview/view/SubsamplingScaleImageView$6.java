package com.davemorrissey.labs.subscaleview.view;

import android.graphics.Bitmap;
import com.tencent.mm.sdk.platformtools.x;

class SubsamplingScaleImageView$6 implements Runnable {
    final /* synthetic */ SubsamplingScaleImageView abb;
    final /* synthetic */ Bitmap abc;
    final /* synthetic */ int abd;
    final /* synthetic */ boolean abe;
    final /* synthetic */ boolean abf;

    SubsamplingScaleImageView$6(SubsamplingScaleImageView subsamplingScaleImageView, int i, Bitmap bitmap, boolean z, boolean z2) {
        this.abb = subsamplingScaleImageView;
        this.abd = i;
        this.abc = bitmap;
        this.abe = z;
        this.abf = z2;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.abd != 0) {
            SubsamplingScaleImageView.b(this.abb, SubsamplingScaleImageView.a(this.abc, this.abd));
        }
        long currentTimeMillis2 = System.currentTimeMillis();
        x.i(SubsamplingScaleImageView.hM(), "alvinluo onImageLoaded rotaeAndScaleBitmap %d", new Object[]{Long.valueOf(currentTimeMillis2 - currentTimeMillis)});
        this.abb.post(new 1(this));
    }
}
