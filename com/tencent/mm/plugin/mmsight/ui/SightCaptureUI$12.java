package com.tencent.mm.plugin.mmsight.ui;

import android.graphics.SurfaceTexture;
import com.tencent.mm.plugin.video.b;

class SightCaptureUI$12 implements b {
    final /* synthetic */ SightCaptureUI lqr;

    SightCaptureUI$12(SightCaptureUI sightCaptureUI) {
        this.lqr = sightCaptureUI;
    }

    public final void d(SurfaceTexture surfaceTexture) {
        SightCaptureUI.c(this.lqr).bfu();
        SightCaptureUI.d(this.lqr).setTextureChangeCallback(null);
    }
}
