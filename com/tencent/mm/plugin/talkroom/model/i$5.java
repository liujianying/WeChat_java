package com.tencent.mm.plugin.talkroom.model;

import com.tencent.mm.ax.d;

class i$5 implements Runnable {
    final /* synthetic */ i oxm;
    final /* synthetic */ String oxn;
    final /* synthetic */ int oxo;
    final /* synthetic */ int oxp;

    i$5(i iVar, String str, int i, int i2) {
        this.oxm = iVar;
        this.oxn = str;
        this.oxo = i;
        this.oxp = i2;
    }

    public final void run() {
        synchronized (this.oxm.cWy) {
            for (d i : this.oxm.cWy) {
                i.i(this.oxn, this.oxo, this.oxp);
            }
        }
    }
}
