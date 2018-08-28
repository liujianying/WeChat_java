package com.tencent.mm.plugin.appbrand.performance;

import android.annotation.TargetApi;
import android.view.Choreographer;
import android.view.Choreographer.FrameCallback;

@TargetApi(16)
public final class d implements FrameCallback {
    Choreographer btz = Choreographer.getInstance();
    boolean fcO = false;
    long gpM = 0;
    int gpN = 0;
    a gpx;
    long mInterval = 200;
    boolean yr = true;

    public interface a {
        void r(double d);
    }

    public final void doFrame(long j) {
        double d = 60.0d;
        if (this.yr && !this.fcO) {
            long j2 = j / 1000000;
            if (this.gpM > 0) {
                long j3 = j2 - this.gpM;
                this.gpN++;
                if (j3 > this.mInterval) {
                    double d2 = ((double) (this.gpN * 1000)) / ((double) j3);
                    if (d2 < 60.0d) {
                        d = d2;
                    }
                    this.gpM = j2;
                    this.gpN = 0;
                    if (this.gpx != null) {
                        this.gpx.r(d);
                    }
                }
            } else {
                this.gpM = j2;
            }
        }
        if (this.yr) {
            this.btz.postFrameCallback(this);
        }
    }
}
