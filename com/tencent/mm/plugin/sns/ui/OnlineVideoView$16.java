package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class OnlineVideoView$16 implements a {
    final /* synthetic */ OnlineVideoView nPH;

    OnlineVideoView$16(OnlineVideoView onlineVideoView) {
        this.nPH = onlineVideoView;
    }

    public final boolean vD() {
        if (OnlineVideoView.k(this.nPH) == null || OnlineVideoView.d(this.nPH) == null) {
            return false;
        }
        if (((View) OnlineVideoView.d(this.nPH)).getAlpha() < 1.0f) {
            OnlineVideoView.m(this.nPH);
        }
        if (OnlineVideoView.d(this.nPH).isPlaying()) {
            OnlineVideoView.n(this.nPH);
        }
        try {
            Object obj;
            if (bi.oW(OnlineVideoView.k(this.nPH).elz)) {
                obj = null;
            } else {
                obj = 1;
            }
            if (obj == null) {
                return false;
            }
            return OnlineVideoView.k(this.nPH).iC(OnlineVideoView.d(this.nPH).getCurrentPosition() / 1000);
        } catch (Exception e) {
            x.e("MicroMsg.OnlineVideoView", "online video timer check error : " + e.toString());
            return false;
        }
    }
}
