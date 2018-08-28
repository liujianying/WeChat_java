package com.tencent.mm.pluginsdk.ui;

class AbstractVideoView$3 implements Runnable {
    final /* synthetic */ AbstractVideoView qED;
    final /* synthetic */ int qEE;

    AbstractVideoView$3(AbstractVideoView abstractVideoView, int i) {
        this.qED = abstractVideoView;
        this.qEE = i;
    }

    public final void run() {
        this.qED.qEt = true;
        this.qED.mH(this.qEE);
        this.qED.x(this.qEE, true);
        this.qED.qEt = false;
    }
}
