package com.tencent.mm.plugin.location.ui;

import com.tencent.mm.sdk.platformtools.ag;

class VolumeMeter$2 implements Runnable {
    final /* synthetic */ VolumeMeter kHD;

    VolumeMeter$2(VolumeMeter volumeMeter) {
        this.kHD = volumeMeter;
    }

    public final void run() {
        VolumeMeter.a(this.kHD, new ag());
        this.kHD.aZR();
    }
}
