package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.ax.d;

class i$10 implements Runnable {
    final /* synthetic */ String kDY;
    final /* synthetic */ String kDZ;
    final /* synthetic */ i oxm;

    i$10(i iVar, String str, String str2) {
        this.oxm = iVar;
        this.kDY = str;
        this.kDZ = str2;
    }

    public final void run() {
        synchronized (this.oxm.cWy) {
            for (d ay : this.oxm.cWy) {
                ay.ay(this.kDY, this.kDZ);
            }
        }
    }
}
