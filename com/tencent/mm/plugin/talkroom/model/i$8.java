package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.ax.d;

class i$8 implements Runnable {
    final /* synthetic */ String bAA;
    final /* synthetic */ i oxm;

    i$8(i iVar, String str) {
        this.oxm = iVar;
        this.bAA = str;
    }

    public final void run() {
        synchronized (this.oxm.cWy) {
            for (d nr : this.oxm.cWy) {
                nr.nr(this.bAA);
            }
        }
    }
}
