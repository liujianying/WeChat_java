package com.tencent.mm.plugin.sight.decode.ui;

class SnsAdNativeLandingPagesVideoPlayerLoadingBar$2 implements Runnable {
    final /* synthetic */ SnsAdNativeLandingPagesVideoPlayerLoadingBar ndT;
    final /* synthetic */ int ndU;

    SnsAdNativeLandingPagesVideoPlayerLoadingBar$2(SnsAdNativeLandingPagesVideoPlayerLoadingBar snsAdNativeLandingPagesVideoPlayerLoadingBar, int i) {
        this.ndT = snsAdNativeLandingPagesVideoPlayerLoadingBar;
        this.ndU = i;
    }

    public final void run() {
        this.ndT.setVideoTotalTime(this.ndU);
    }
}
