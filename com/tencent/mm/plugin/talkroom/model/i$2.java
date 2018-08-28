package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.ax.d;

class i$2 implements Runnable {
    final /* synthetic */ i oxm;

    i$2(i iVar) {
        this.oxm = iVar;
    }

    public final void run() {
        synchronized (this.oxm.cWy) {
            for (d Sw : this.oxm.cWy) {
                Sw.Sw();
            }
        }
    }
}
