package com.tencent.mm.plugin.sns.ui;

import android.view.View;
import com.tencent.mm.sdk.platformtools.x;

class OfflineVideoView$4 implements Runnable {
    final /* synthetic */ boolean hEu;
    final /* synthetic */ OfflineVideoView nPk;
    final /* synthetic */ float nPl;

    OfflineVideoView$4(OfflineVideoView offlineVideoView, boolean z, float f) {
        this.nPk = offlineVideoView;
        this.hEu = z;
        this.nPl = f;
    }

    public final void run() {
        x.i("MicroMsg.OfflineVideoView", "%d switch video model isVideoPlay %b %f", new Object[]{Integer.valueOf(this.nPk.hashCode()), Boolean.valueOf(this.hEu), Float.valueOf(this.nPl)});
        View view = (View) OfflineVideoView.b(this.nPk);
        if (this.hEu) {
            view.setAlpha(this.nPl);
            view.setVisibility(0);
            OfflineVideoView.c(this.nPk).setVisibility(0);
            OfflineVideoView.c(this.nPk).setAlpha(this.nPl);
            if (((double) this.nPl) >= 1.0d) {
                OfflineVideoView.a(this.nPk).setVisibility(8);
                return;
            }
            return;
        }
        view.setVisibility(0);
        OfflineVideoView.c(this.nPk).setVisibility(0);
        OfflineVideoView.c(this.nPk).setAlpha(0.0f);
        OfflineVideoView.a(this.nPk).setVisibility(0);
    }
}
