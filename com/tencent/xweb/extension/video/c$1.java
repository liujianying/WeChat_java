package com.tencent.xweb.extension.video;

import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;

class c$1 implements Callback {
    final /* synthetic */ c vCb;

    c$1(c cVar) {
        this.vCb = cVar;
    }

    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        Canvas lockCanvas = surfaceHolder.lockCanvas();
        lockCanvas.drawColor(-16777216);
        surfaceHolder.unlockCanvasAndPost(lockCanvas);
    }

    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        Canvas lockCanvas = surfaceHolder.lockCanvas();
        lockCanvas.drawColor(-16777216);
        surfaceHolder.unlockCanvasAndPost(lockCanvas);
    }

    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }
}
