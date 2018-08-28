package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.z.8;
import com.tencent.mm.sdk.platformtools.x;

class z$8$3 implements Runnable {
    final /* synthetic */ int gcp;
    final /* synthetic */ 8 nFQ;

    z$8$3(8 8, int i) {
        this.nFQ = 8;
        this.gcp = i;
    }

    public final void run() {
        x.d("MicroMsg.Sns.AdLandingPageStreamVideoComponentOnlinePlayer", "play time " + this.gcp + " video time " + this.nFQ.nFO.nFC);
        if (this.nFQ.nFO.nEG.getVideoTotalTime() != this.nFQ.nFO.nFC) {
            this.nFQ.nFO.nEG.setVideoTotalTime(this.nFQ.nFO.nFC);
        }
        this.nFQ.nFO.nEG.seek(this.gcp);
        this.nFQ.nFO.nEG.setIsPlay(this.nFQ.nFO.nFA.isPlaying());
        if (this.nFQ.nFO.nFA.isPlaying()) {
            this.nFQ.nFO.djm = true;
        }
    }
}
