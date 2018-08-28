package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import com.tencent.mm.sdk.platformtools.x;

class OnlineVideoView$11 implements Runnable {
    final /* synthetic */ boolean hEu;
    final /* synthetic */ OnlineVideoView nPH;
    final /* synthetic */ float nPl;

    OnlineVideoView$11(OnlineVideoView onlineVideoView, boolean z, float f) {
        this.nPH = onlineVideoView;
        this.hEu = z;
        this.nPl = f;
    }

    public final void run() {
        x.i("MicroMsg.OnlineVideoView", "%d switch video model isVideoPlay %b %f", new Object[]{Integer.valueOf(this.nPH.hashCode()), Boolean.valueOf(this.hEu), Float.valueOf(this.nPl)});
        View view = (View) OnlineVideoView.d(this.nPH);
        if (this.hEu) {
            OnlineVideoView.f(this.nPH).setAlpha(this.nPl);
            OnlineVideoView.f(this.nPH).setVisibility(0);
            view.setAlpha(this.nPl);
            view.setVisibility(0);
            if (((double) this.nPl) >= 1.0d) {
                OnlineVideoView.g(this.nPH).setVisibility(8);
                return;
            }
            return;
        }
        OnlineVideoView.f(this.nPH).setVisibility(8);
        view.setVisibility(8);
        OnlineVideoView.g(this.nPH).setVisibility(0);
    }
}
