package com.tencent.mm.plugin.game.model;

import com.tencent.mm.ab.e;
import com.tencent.mm.ab.l;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.d.bf;
import com.tencent.mm.plugin.game.model.aq.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.x;

class aq$1 implements e {
    final /* synthetic */ a jOx;

    aq$1(a aVar) {
        this.jOx = aVar;
    }

    public final void a(int i, int i2, String str, l lVar) {
        g.DF().b(2641, this);
        if (i == 0 && i2 == 0) {
            x.i("MicroMsg.NetSceneGameIndex4TabNav", "pull gameIndexTabNav data success");
            ah.A(new 1(this, (bf) ((aq) lVar).ivx.dIE.dIL));
            return;
        }
        x.i("MicroMsg.NetSceneGameIndex4TabNav", "pull gameIndexTabNav data fail");
    }
}
