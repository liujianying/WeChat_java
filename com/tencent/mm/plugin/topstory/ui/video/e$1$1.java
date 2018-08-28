package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.mm.plugin.topstory.ui.video.e.1;

class e$1$1 implements Runnable {
    final /* synthetic */ 1 oAa;
    final /* synthetic */ int ozZ;

    e$1$1(1 1, int i) {
        this.oAa = 1;
        this.ozZ = i;
    }

    public final void run() {
        if (this.oAa.ozY.ozW != null) {
            this.oAa.ozY.ozW.dM(this.ozZ, this.oAa.ozY.ozX);
        }
    }
}
