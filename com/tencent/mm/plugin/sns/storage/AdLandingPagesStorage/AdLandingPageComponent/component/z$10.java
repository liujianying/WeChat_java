package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component;

import com.tencent.mm.plugin.sns.ui.OfflineVideoView;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;

class z$10 implements Runnable {
    final /* synthetic */ z nFO;

    z$10(z zVar) {
        this.nFO = zVar;
    }

    public final void run() {
        OfflineVideoView offlineVideoView = this.nFO.nFA;
        boolean isPlaying = offlineVideoView.hEl instanceof VideoPlayerTextureView ? ((VideoPlayerTextureView) offlineVideoView.hEl).cfx() && offlineVideoView.isPlaying() : offlineVideoView.isPlaying();
        if (isPlaying) {
            this.nFO.nFA.anA();
            return;
        }
        this.nFO.nEG.setIsPlay(true);
        this.nFO.nFA.bCn();
    }
}
