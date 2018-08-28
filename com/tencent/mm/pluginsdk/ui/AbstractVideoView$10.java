package com.tencent.mm.pluginsdk.ui;

class AbstractVideoView$10 implements Runnable {
    final /* synthetic */ AbstractVideoView qED;

    AbstractVideoView$10(AbstractVideoView abstractVideoView) {
        this.qED = abstractVideoView;
    }

    public final void run() {
        if (this.qED.qEj != null && this.qED.qEj.getVisibility() != 0) {
            this.qED.qEj.setVisibility(0);
        }
    }
}
