package com.tencent.mm.plugin.mmsight.model.a;

import com.tencent.mm.sdk.platformtools.x;

public class p implements f {
    volatile int frameCount = 0;
    long hng = 0;
    int kGn;
    int kGo;
    boolean lgJ;
    long lhs = 0;
    int ljv = -1;
    int ljw = -1;
    int ljx = -1;
    int ljy = -1;
    int ljz = -1;

    public p(boolean z, int i, int i2, int i3) {
        this.lgJ = z;
        this.ljw = i;
        this.kGn = i2;
        this.kGo = i3;
        x.i("MicroMsg.MMSightX264YUVRecorder", "create MMSightX264YUVRecorder, needRotateEachFrame: %s, initRotate: %s, targetWidth: %s, targetHeight: %s", new Object[]{Boolean.valueOf(z), Integer.valueOf(this.ljw), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public final int sT(int i) {
        if (i < 0) {
            x.e("MicroMsg.MMSightX264YUVRecorder", "init error, yuv buffer id error");
            return -1;
        }
        this.ljv = i;
        synchronized (p.class) {
            this.frameCount = 0;
        }
        this.hng = 0;
        return 0;
    }

    public final void stop() {
        synchronized (p.class) {
            this.frameCount = 0;
        }
        this.hng = 0;
    }

    public final long beD() {
        if (0 != this.hng) {
            return System.currentTimeMillis() - this.hng;
        }
        x.w("MicroMsg.MMSightX264YUVRecorder", "do not start record");
        return 0;
    }
}
