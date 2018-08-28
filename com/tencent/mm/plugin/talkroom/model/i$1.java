package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.ax.d;

class i$1 implements Runnable {
    final /* synthetic */ i oxm;

    i$1(i iVar) {
        this.oxm = iVar;
    }

    public final void run() {
        synchronized (this.oxm.cWy) {
            for (d St : this.oxm.cWy) {
                St.St();
            }
        }
    }
}
