package com.tencent.mm.plugin.webview.ui.tools;

import android.support.v4.view.z;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;

final class LogoWebViewWrapper$c implements Runnable {
    private final long duration;
    final /* synthetic */ LogoWebViewWrapper pVE;
    private final Interpolator pVF;
    private final int pVG;
    private final int pVH;
    boolean pVI = true;
    private int pVJ = -1;
    private long startTime = -1;

    public LogoWebViewWrapper$c(LogoWebViewWrapper logoWebViewWrapper, int i, int i2, long j) {
        this.pVE = logoWebViewWrapper;
        this.pVH = i;
        this.pVG = i2;
        this.pVF = LogoWebViewWrapper.b(logoWebViewWrapper) ? new AccelerateInterpolator() : new DecelerateInterpolator();
        this.duration = j;
    }

    public final void run() {
        if (this.startTime == -1) {
            this.startTime = System.currentTimeMillis();
        } else {
            long j = 500;
            if (this.duration > 0) {
                j = Math.max(Math.min(((System.currentTimeMillis() - this.startTime) * 1000) / this.duration, 1000), 0);
            }
            this.pVJ = this.pVH - Math.round(this.pVF.getInterpolation(((float) j) / 1000.0f) * ((float) (this.pVH - this.pVG)));
            this.pVE.AB(this.pVJ);
            if (LogoWebViewWrapper.c(this.pVE) != null) {
                LogoWebViewWrapper.c(this.pVE).Y(this.pVJ, false);
            }
        }
        if (this.pVI && this.pVG != this.pVJ) {
            z.a(this.pVE, this);
        }
    }
}
