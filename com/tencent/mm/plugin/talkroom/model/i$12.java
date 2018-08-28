package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.ax.d;

class i$12 implements Runnable {
    final /* synthetic */ i oxm;

    i$12(i iVar) {
        this.oxm = iVar;
    }

    public final void run() {
        synchronized (this.oxm.cWy) {
            for (d Sv : this.oxm.cWy) {
                Sv.Sv();
            }
        }
    }
}
