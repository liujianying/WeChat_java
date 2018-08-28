package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.x;

class OfflineVideoView$6 implements Runnable {
    final /* synthetic */ OfflineVideoView nPk;

    OfflineVideoView$6(OfflineVideoView offlineVideoView) {
        this.nPk = offlineVideoView;
    }

    public final void run() {
        if (OfflineVideoView.d(this.nPk) != null && OfflineVideoView.d(this.nPk).getVisibility() != 8) {
            x.i("MicroMsg.OfflineVideoView", "%d hide loading.", new Object[]{Integer.valueOf(this.nPk.hashCode())});
            OfflineVideoView.d(this.nPk).setVisibility(8);
        }
    }
}
