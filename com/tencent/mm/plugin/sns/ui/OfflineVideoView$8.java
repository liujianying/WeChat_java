package com.tencent.mm.plugin.sns.ui;

import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.sdk.platformtools.x;

class OfflineVideoView$8 implements e {
    final /* synthetic */ OfflineVideoView nPk;

    OfflineVideoView$8(OfflineVideoView offlineVideoView) {
        this.nPk = offlineVideoView;
    }

    public final void bfs() {
        x.i("MicroMsg.OfflineVideoView", "%d on texture update.", new Object[]{Integer.valueOf(this.nPk.hashCode())});
        try {
            OfflineVideoView.e(this.nPk);
        } catch (Exception e) {
            x.e("MicroMsg.OfflineVideoView", "texture view update. error " + e.toString());
        }
    }
}
