package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.sns.model.aq;
import com.tencent.mm.sdk.platformtools.x;

class OnlineVideoView$9 implements Runnable {
    final /* synthetic */ OnlineVideoView nPH;

    OnlineVideoView$9(OnlineVideoView onlineVideoView) {
        this.nPH = onlineVideoView;
    }

    public final void run() {
        x.w("MicroMsg.OnlineVideoView", "%d deal sns video change isOnlinePlay[%b]", new Object[]{Integer.valueOf(this.nPH.hashCode()), Boolean.valueOf(OnlineVideoView.x(this.nPH))});
        if (OnlineVideoView.x(this.nPH)) {
            OnlineVideoView.y(this.nPH);
            OnlineVideoView.d(this.nPH).stop();
            this.nPH.bCq();
            boolean deleteFile = FileOp.deleteFile(aq.D(OnlineVideoView.e(this.nPH)));
            if (OnlineVideoView.k(this.nPH) != null) {
                OnlineVideoView.k(this.nPH).bCw();
                OnlineVideoView.k(this.nPH).clear();
                OnlineVideoView.a(this.nPH, new af(this.nPH));
            }
            x.i("MicroMsg.OnlineVideoView", "%d delete video file[%b] [%s]", new Object[]{Integer.valueOf(this.nPH.hashCode()), Boolean.valueOf(deleteFile), r0});
            OnlineVideoView.z(this.nPH);
            OnlineVideoView.A(this.nPH);
        }
    }
}
