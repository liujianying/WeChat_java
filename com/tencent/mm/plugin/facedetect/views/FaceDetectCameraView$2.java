package com.tencent.mm.plugin.facedetect.views;

import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import com.tencent.mm.sdk.platformtools.x;

class FaceDetectCameraView$2 implements Runnable {
    final /* synthetic */ FaceDetectCameraView iTq;
    final /* synthetic */ int iTr;
    final /* synthetic */ int iTs;
    final /* synthetic */ int iTt;

    FaceDetectCameraView$2(FaceDetectCameraView faceDetectCameraView, int i, int i2, int i3) {
        this.iTq = faceDetectCameraView;
        this.iTr = i;
        this.iTs = i2;
        this.iTt = i3;
    }

    public final void run() {
        int i = this.iTr - this.iTs;
        x.i("MicroMsg.FaceDetectCameraView", "alvinluo restHeight: %d", new Object[]{Integer.valueOf(i)});
        if (i > 0) {
            i /= 2;
            LayoutParams layoutParams = new FrameLayout.LayoutParams(this.iTt, this.iTs);
            MarginLayoutParams marginLayoutParams = new MarginLayoutParams(this.iTq.getLayoutParams());
            layoutParams.setMargins(marginLayoutParams.leftMargin, i, marginLayoutParams.rightMargin, marginLayoutParams.height + i);
            x.v("MicroMsg.FaceDetectCameraView", "alvinluo margin left: %d, right: %d, top: %d, bottom: %d", new Object[]{Integer.valueOf(marginLayoutParams.leftMargin), Integer.valueOf(marginLayoutParams.rightMargin), Integer.valueOf(i), Integer.valueOf(i + marginLayoutParams.height)});
            this.iTq.setLayoutParams(layoutParams);
            this.iTq.invalidate();
        }
    }
}
