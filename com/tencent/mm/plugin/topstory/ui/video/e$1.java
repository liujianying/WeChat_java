package com.tencent.mm.plugin.topstory.ui.video;

import com.tencent.mm.network.n.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class e$1 extends a {
    final /* synthetic */ e ozY;

    e$1(e eVar) {
        this.ozY = eVar;
    }

    public final void ev(int i) {
        int i2 = this.ozY.ozX;
        this.ozY.ozX = e.bIa();
        if (this.ozY.ozX != i2) {
            x.i("MicroMsg.TopStory.TopStoryNetworkMgr", "network change current:%d change:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(this.ozY.ozX)});
            ah.A(new 1(this, i2));
        }
    }
}
