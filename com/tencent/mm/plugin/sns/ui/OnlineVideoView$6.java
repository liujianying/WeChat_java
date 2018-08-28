package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.sdk.platformtools.x;

class OnlineVideoView$6 implements e {
    final /* synthetic */ OnlineVideoView nPH;

    OnlineVideoView$6(OnlineVideoView onlineVideoView) {
        this.nPH = onlineVideoView;
    }

    public final void bfs() {
        x.i("MicroMsg.OnlineVideoView", "%d on texture update.", new Object[]{Integer.valueOf(this.nPH.hashCode())});
        try {
            OnlineVideoView.m(this.nPH);
        } catch (Exception e) {
            x.e("MicroMsg.OnlineVideoView", "texture view update. error " + e.toString());
        }
    }
}
