package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.x;

class bi$3 implements Runnable {
    final /* synthetic */ bi ohY;

    bi$3(bi biVar) {
        this.ohY = biVar;
    }

    public final void run() {
        x.d("MicroMsg.TimeLineScrollAnimation", "originalTop:" + this.ohY.ohQ + " position:" + this.ohY.position + " list.bottom:" + this.ohY.kww.getBottom());
    }
}
