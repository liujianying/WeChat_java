package com.tencent.mm.plugin.sns.ui;

import com.tencent.tmassistantsdk.logreport.BaseReportManager;

class OnlineVideoView$15 implements Runnable {
    final /* synthetic */ OnlineVideoView nPH;

    OnlineVideoView$15(OnlineVideoView onlineVideoView) {
        this.nPH = onlineVideoView;
    }

    public final void run() {
        if (!(OnlineVideoView.d(this.nPH) == null || OnlineVideoView.k(this.nPH) == null)) {
            OnlineVideoView.k(this.nPH).iC(OnlineVideoView.d(this.nPH).getCurrentPosition() / BaseReportManager.MAX_READ_COUNT);
        }
        OnlineVideoView.l(this.nPH).J(500, 500);
    }
}
