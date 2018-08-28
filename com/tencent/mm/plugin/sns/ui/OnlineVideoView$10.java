package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class OnlineVideoView$10 implements Runnable {
    final /* synthetic */ OnlineVideoView nPH;

    OnlineVideoView$10(OnlineVideoView onlineVideoView) {
        this.nPH = onlineVideoView;
    }

    public final void run() {
        if (OnlineVideoView.d(this.nPH) == null) {
            return;
        }
        if (bi.oW(OnlineVideoView.d(this.nPH).getVideoPath())) {
            x.i("MicroMsg.OnlineVideoView", "%d had not set video path to play", new Object[]{Integer.valueOf(this.nPH.hashCode())});
            String a = aq.a(OnlineVideoView.a(this.nPH), OnlineVideoView.e(this.nPH));
            if (!bi.oW(a)) {
                this.nPH.aX(a, false);
            }
        } else if (!OnlineVideoView.d(this.nPH).isPlaying()) {
            OnlineVideoView.d(this.nPH).start();
        }
    }
}
