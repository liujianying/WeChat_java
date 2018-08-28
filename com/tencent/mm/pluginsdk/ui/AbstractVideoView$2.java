package com.tencent.mm.pluginsdk.ui;

class AbstractVideoView$2 implements Runnable {
    final /* synthetic */ AbstractVideoView qED;

    AbstractVideoView$2(AbstractVideoView abstractVideoView) {
        this.qED = abstractVideoView;
    }

    public final void run() {
        try {
            this.qED.mH(0);
            AbstractVideoView.a(this.qED, this.qED.isPlaying());
        } catch (Throwable th) {
        }
    }
}
