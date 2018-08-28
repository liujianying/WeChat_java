package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.graphics.Canvas;

class MSurfaceView$2 implements Runnable {
    final /* synthetic */ MSurfaceView fnJ;

    MSurfaceView$2(MSurfaceView mSurfaceView) {
        this.fnJ = mSurfaceView;
    }

    public final void run() {
        if (!MSurfaceView.a(this.fnJ)) {
            Canvas lockCanvas = MSurfaceView.b(this.fnJ).lockCanvas();
            if (lockCanvas != null) {
                lockCanvas.drawColor(-1);
                this.fnJ.d(lockCanvas);
                MSurfaceView.b(this.fnJ).unlockCanvasAndPost(lockCanvas);
            }
        }
    }
}
