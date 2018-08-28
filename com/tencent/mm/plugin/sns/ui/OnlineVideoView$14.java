package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.x;

class OnlineVideoView$14 implements Runnable {
    final /* synthetic */ OnlineVideoView nPH;

    OnlineVideoView$14(OnlineVideoView onlineVideoView) {
        this.nPH = onlineVideoView;
    }

    public final void run() {
        if (!(OnlineVideoView.h(this.nPH) == null || OnlineVideoView.h(this.nPH).getVisibility() == 8)) {
            x.i("MicroMsg.OnlineVideoView", "%d hide loading.", new Object[]{Integer.valueOf(this.nPH.hashCode())});
            OnlineVideoView.h(this.nPH).setVisibility(8);
        }
        if (OnlineVideoView.i(this.nPH) != null && OnlineVideoView.i(this.nPH).getVisibility() != 8) {
            x.i("MicroMsg.OnlineVideoView", "%d hide progress.", new Object[]{Integer.valueOf(this.nPH.hashCode())});
            OnlineVideoView.i(this.nPH).setVisibility(8);
        }
    }
}
