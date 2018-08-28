package com.tencent.mm.plugin.game.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.plugin.game.d.bf;
import com.tencent.mm.sdk.platformtools.x;

class aq$2 implements aq$b {
    final /* synthetic */ bf jOy;

    aq$2(bf bfVar) {
        this.jOy = bfVar;
    }

    public final void onComplete() {
        x.i("MicroMsg.NetSceneGameIndex4TabNav", "nav icon download complete! save nav data");
        ((c) g.l(c.class)).aSk().a("game_index4_tab_nav", this.jOy);
    }
}
