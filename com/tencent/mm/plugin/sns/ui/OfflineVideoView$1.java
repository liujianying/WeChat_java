package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.x;

class OfflineVideoView$1 implements Runnable {
    final /* synthetic */ String nPj;
    final /* synthetic */ OfflineVideoView nPk;

    OfflineVideoView$1(OfflineVideoView offlineVideoView, String str) {
        this.nPk = offlineVideoView;
        this.nPj = str;
    }

    public final void run() {
        if (OfflineVideoView.a(this.nPk) != null) {
            x.i("MicroMsg.OfflineVideoView", "%d fresh thumb image", new Object[]{Integer.valueOf(hashCode())});
            OfflineVideoView.a(this.nPk).setImageBitmap(b.e(this.nPj, 1.0f));
        }
    }
}
