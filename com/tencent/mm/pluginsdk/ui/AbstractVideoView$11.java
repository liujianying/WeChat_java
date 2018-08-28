package com.tencent.mm.pluginsdk.ui;

class AbstractVideoView$11 implements Runnable {
    final /* synthetic */ AbstractVideoView qED;

    AbstractVideoView$11(AbstractVideoView abstractVideoView) {
        this.qED = abstractVideoView;
    }

    public final void run() {
        if (this.qED.qEj != null && this.qED.qEj.getVisibility() != 8) {
            this.qED.qEj.setVisibility(8);
        }
    }
}
