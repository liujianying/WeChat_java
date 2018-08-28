package com.tencent.mm.plugin.location.ui;

import android.os.Looper;
import com.tencent.mm.sdk.platformtools.ag;

class VolumeMeter$1 implements Runnable {
    final /* synthetic */ VolumeMeter kHD;

    VolumeMeter$1(VolumeMeter volumeMeter) {
        this.kHD = volumeMeter;
    }

    public final void run() {
        Looper.prepare();
        VolumeMeter.a(this.kHD, new ag());
        Looper.loop();
    }
}
