package com.tencent.mm.plugin.shake.ui;

import com.tencent.mm.plugin.shake.e.c.a;

class TVInfoUI$5 implements Runnable {
    final /* synthetic */ a nbC;
    final /* synthetic */ TVInfoUI nbD;

    TVInfoUI$5(TVInfoUI tVInfoUI, a aVar) {
        this.nbD = tVInfoUI;
        this.nbC = aVar;
    }

    public final void run() {
        TVInfoUI.a(this.nbD, this.nbC);
        TVInfoUI.b(this.nbD, this.nbC);
    }
}
