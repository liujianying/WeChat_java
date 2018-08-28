package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x.10;
import com.tencent.mm.sdk.platformtools.x;

class x$10$2 implements Runnable {
    final /* synthetic */ int gcp;
    final /* synthetic */ 10 nFN;

    x$10$2(10 10, int i) {
        this.nFN = 10;
        this.gcp = i;
    }

    public final void run() {
        x.d("MicroMsg.Sns.AdLandingPageSightVideoComponent", "play time " + this.gcp + " video time " + x.q(this.nFN.nFL));
        if (this.nFN.nFL.nEG.getVideoTotalTime() != x.q(this.nFN.nFL)) {
            this.nFN.nFL.nEG.setVideoTotalTime(x.q(this.nFN.nFL));
        }
        this.nFN.nFL.nEG.seek(this.gcp);
        this.nFN.nFL.nEG.setIsPlay(x.a(this.nFN.nFL).isPlaying());
        if (x.a(this.nFN.nFL).isPlaying()) {
            x.p(this.nFN.nFL);
        }
    }
}
