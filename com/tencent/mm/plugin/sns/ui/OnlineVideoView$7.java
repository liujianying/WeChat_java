package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.u.b;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

class OnlineVideoView$7 implements b {
    final /* synthetic */ OnlineVideoView nPH;

    OnlineVideoView$7(OnlineVideoView onlineVideoView) {
        this.nPH = onlineVideoView;
    }

    public final long bdp() {
        x.i("MicroMsg.OnlineVideoView", "%d sns video get online cache", new Object[]{Integer.valueOf(this.nPH.hashCode())});
        g.Ek();
        g.Ei().DT().a(a.sVF, Boolean.valueOf(true));
        try {
            if (OnlineVideoView.x(this.nPH) && OnlineVideoView.k(this.nPH) != null) {
                return (long) OnlineVideoView.k(this.nPH).elJ;
            }
        } catch (Exception e) {
        }
        return 0;
    }
}
