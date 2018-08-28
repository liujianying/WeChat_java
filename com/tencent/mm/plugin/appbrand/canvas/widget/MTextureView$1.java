package com.tencent.mm.plugin.appbrand.canvas.widget;

import android.graphics.Canvas;

class MTextureView$1 implements Runnable {
    final /* synthetic */ MTextureView fnL;

    MTextureView$1(MTextureView mTextureView) {
        this.fnL = mTextureView;
    }

    public final void run() {
        if (this.fnL.isAvailable()) {
            Canvas lockCanvas = this.fnL.lockCanvas();
            if (lockCanvas != null) {
                synchronized (MTextureView.a(this.fnL)) {
                    MTextureView.a(this.fnL, true);
                }
                lockCanvas.drawColor(-1);
                this.fnL.d(lockCanvas);
                this.fnL.unlockCanvasAndPost(lockCanvas);
                synchronized (MTextureView.a(this.fnL)) {
                    MTextureView.a(this.fnL, false);
                    MTextureView.a(this.fnL).notifyAll();
                }
            }
        }
    }
}
