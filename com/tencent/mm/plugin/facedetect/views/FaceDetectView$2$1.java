package com.tencent.mm.plugin.facedetect.views;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.tencent.mm.plugin.facedetect.views.FaceDetectView.2;

class FaceDetectView$2$1 implements Runnable {
    final /* synthetic */ Bitmap iTZ;
    final /* synthetic */ 2 iUa;

    FaceDetectView$2$1(2 2, Bitmap bitmap) {
        this.iUa = 2;
        this.iTZ = bitmap;
    }

    public final void run() {
        FaceDetectView.i(this.iUa.iTY).setVisibility(0);
        FaceDetectView.i(this.iUa.iTY).setBackgroundDrawable(new BitmapDrawable(this.iTZ));
    }
}
