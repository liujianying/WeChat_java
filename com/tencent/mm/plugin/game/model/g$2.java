package com.tencent.mm.plugin.game.model;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.game.a.c;
import com.tencent.mm.protocal.c.alt;
import com.tencent.mm.sdk.platformtools.x;

class g$2 implements g$a {
    final /* synthetic */ String fFV;
    final /* synthetic */ alt jLH;

    g$2(String str, alt alt) {
        this.fFV = str;
        this.jLH = alt;
    }

    public final void onComplete() {
        x.i("MicroMsg.GameCommOpertionProcessor", "menu icon download complete! save menu data. appid:%s", new Object[]{this.fFV});
        ((c) g.l(c.class)).aSk().a("pb_game_hv_menu_" + this.fFV, this.jLH);
    }
}
