package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.x;

class OnlineVideoView$13 implements Runnable {
    final /* synthetic */ OnlineVideoView nPH;

    OnlineVideoView$13(OnlineVideoView onlineVideoView) {
        this.nPH = onlineVideoView;
    }

    public final void run() {
        x.i("MicroMsg.OnlineVideoView", "%d show loading. downloadMode %d", new Object[]{Integer.valueOf(this.nPH.hashCode()), Integer.valueOf(OnlineVideoView.j(this.nPH))});
        if (OnlineVideoView.j(this.nPH) == 1) {
            if (!(OnlineVideoView.h(this.nPH) == null || OnlineVideoView.h(this.nPH).getVisibility() == 0)) {
                OnlineVideoView.h(this.nPH).setVisibility(0);
            }
            if (!(OnlineVideoView.i(this.nPH) == null || OnlineVideoView.i(this.nPH).getVisibility() == 8)) {
                OnlineVideoView.i(this.nPH).setVisibility(8);
            }
        }
        if (OnlineVideoView.j(this.nPH) == 2) {
            if (!(OnlineVideoView.i(this.nPH) == null || OnlineVideoView.i(this.nPH).getVisibility() == 0)) {
                OnlineVideoView.i(this.nPH).setVisibility(0);
            }
            if (!(OnlineVideoView.h(this.nPH) == null || OnlineVideoView.h(this.nPH).getVisibility() == 8)) {
                OnlineVideoView.h(this.nPH).setVisibility(8);
            }
        }
        if (OnlineVideoView.j(this.nPH) == 3) {
            if (!(OnlineVideoView.i(this.nPH) == null || OnlineVideoView.i(this.nPH).getVisibility() == 0)) {
                OnlineVideoView.i(this.nPH).setVisibility(0);
                OnlineVideoView.i(this.nPH).cAt();
            }
            if (OnlineVideoView.h(this.nPH) != null && OnlineVideoView.h(this.nPH).getVisibility() != 8) {
                OnlineVideoView.h(this.nPH).setVisibility(8);
            }
        }
    }
}
