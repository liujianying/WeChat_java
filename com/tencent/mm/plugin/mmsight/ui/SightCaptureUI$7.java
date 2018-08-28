package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.SurfaceTexture;
import com.tencent.mm.plugin.video.b;
import com.tencent.mm.sdk.platformtools.x;

class SightCaptureUI$7 implements b {
    final /* synthetic */ SightCaptureUI lqr;

    SightCaptureUI$7(SightCaptureUI sightCaptureUI) {
        this.lqr = sightCaptureUI;
    }

    public final void d(SurfaceTexture surfaceTexture) {
        x.i("MicroMsg.SightCaptureUI", "callback onSurfaceTextureAvailable set local surface: %s", new Object[]{surfaceTexture});
        SightCaptureUI.a(this.lqr, surfaceTexture);
        if (SightCaptureUI.I(this.lqr)) {
            SightCaptureUI.g(this.lqr, 1);
        } else {
            SightCaptureUI.g(this.lqr, 8);
        }
    }
}
