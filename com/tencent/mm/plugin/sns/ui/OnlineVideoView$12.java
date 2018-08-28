package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.x;

class OnlineVideoView$12 implements Runnable {
    final /* synthetic */ int dPF;
    final /* synthetic */ int dVx;
    final /* synthetic */ OnlineVideoView nPH;

    OnlineVideoView$12(OnlineVideoView onlineVideoView, int i, int i2) {
        this.nPH = onlineVideoView;
        this.dPF = i;
        this.dVx = i2;
    }

    public final void run() {
        if (!(OnlineVideoView.h(this.nPH) == null || OnlineVideoView.h(this.nPH).getVisibility() == 8)) {
            OnlineVideoView.h(this.nPH).setVisibility(8);
        }
        if (OnlineVideoView.i(this.nPH) != null) {
            if (OnlineVideoView.i(this.nPH).getVisibility() != 0) {
                OnlineVideoView.i(this.nPH).setVisibility(0);
            }
            x.i("MicroMsg.OnlineVideoView", "%d update progress %d %d", new Object[]{Integer.valueOf(this.nPH.hashCode()), Integer.valueOf(this.dPF), Integer.valueOf(this.dVx)});
            if (OnlineVideoView.i(this.nPH).getMax() != this.dVx && this.dVx > 0) {
                OnlineVideoView.i(this.nPH).setMax(this.dVx);
            }
            OnlineVideoView.i(this.nPH).setProgress(this.dPF);
        }
    }
}
