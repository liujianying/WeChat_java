package com.tencent.mm.plugin.sns.ui;

class OfflineVideoView$2 implements Runnable {
    final /* synthetic */ String jfT;
    final /* synthetic */ OfflineVideoView nPk;

    OfflineVideoView$2(OfflineVideoView offlineVideoView, String str) {
        this.nPk = offlineVideoView;
        this.jfT = str;
    }

    public final void run() {
        this.nPk.BK(this.jfT);
    }
}
