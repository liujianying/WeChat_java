package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

class r$9 implements Runnable {
    final /* synthetic */ r nFh;

    r$9(r rVar) {
        this.nFh = rVar;
    }

    public final void run() {
        if (!this.nFh.nEF.isPlaying()) {
            if (this.nFh.nEF.getCurrPosSec() == this.nFh.nEF.getVideoDurationSec()) {
                this.nFh.wP(0);
            } else {
                this.nFh.wP(this.nFh.nEF.getCurrPosSec());
            }
        }
    }
}
