package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.sdk.platformtools.x;

class ak$3 implements Runnable {
    final /* synthetic */ ak tSU;

    ak$3(ak akVar) {
        this.tSU = akVar;
    }

    public final void run() {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this.tSU) {
            ak.bZR().clear();
            ak.cwk().clear();
        }
        x.i("MicroMsg.TransformComponent", "alvinluo unsetTransformFlag cost: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }
}
