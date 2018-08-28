package com.tencent.mm.plugin.game.ui.tab;

import com.tencent.mm.plugin.game.d.bf;
import com.tencent.mm.plugin.game.model.aq.a;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.sdk.platformtools.x;

class GameRouteUI$1 implements a {
    final /* synthetic */ GameRouteUI kcQ;

    GameRouteUI$1(GameRouteUI gameRouteUI) {
        this.kcQ = gameRouteUI;
    }

    public final void b(bf bfVar) {
        if (bfVar == null || bi.cX(bfVar.jQF)) {
            x.e("MicroMsg.GameRouteUI", "get GameIndex4TabNavData err");
            GameRouteUI.a(this.kcQ);
            return;
        }
        GameRouteUI.a(this.kcQ, bfVar.jQF);
    }
}
