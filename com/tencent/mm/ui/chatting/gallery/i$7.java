package com.tencent.mm.ui.chatting.gallery;

import com.tencent.mm.pluginsdk.ui.tools.f.e;
import com.tencent.mm.sdk.platformtools.x;

class i$7 implements e {
    final /* synthetic */ i tWK;

    i$7(i iVar) {
        this.tWK = iVar;
    }

    public final void bfs() {
        x.i("MicroMsg.Imagegallery.handler.video", "%d on texture update.", new Object[]{Integer.valueOf(this.tWK.hashCode())});
        try {
            this.tWK.tTx.cwO().a(true, 1.0f);
        } catch (Exception e) {
            x.e("MicroMsg.Imagegallery.handler.video", "texture view update. error " + e.toString());
        }
    }
}
