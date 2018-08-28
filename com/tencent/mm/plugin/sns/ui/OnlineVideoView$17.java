package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import com.tencent.mm.sdk.platformtools.al.a;

class OnlineVideoView$17 implements a {
    final /* synthetic */ OnlineVideoView nPH;

    OnlineVideoView$17(OnlineVideoView onlineVideoView) {
        this.nPH = onlineVideoView;
    }

    public final boolean vD() {
        if (OnlineVideoView.d(this.nPH) == null) {
            return false;
        }
        if (((View) OnlineVideoView.d(this.nPH)).getAlpha() < 1.0f) {
            OnlineVideoView.m(this.nPH);
        }
        if (OnlineVideoView.d(this.nPH).isPlaying()) {
            OnlineVideoView.n(this.nPH);
            OnlineVideoView.d(this.nPH).getCurrentPosition();
        }
        return true;
    }
}
