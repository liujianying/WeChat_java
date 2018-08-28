package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.d.cy;
import com.tencent.mm.plugin.game.f.h;
import com.tencent.mm.plugin.game.f.i;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

class GameDetailUI2$7 implements c {
    final /* synthetic */ GameDetailUI2 jXr;
    final /* synthetic */ cy jXs;

    GameDetailUI2$7(GameDetailUI2 gameDetailUI2, cy cyVar) {
        this.jXr = gameDetailUI2;
        this.jXs = cyVar;
    }

    public final void a(l lVar) {
        if (this.jXs.jTp) {
            lVar.a(0, this.jXr.getString(i.game_send_to_friend), h.bottomsheet_icon_transmit);
        }
        if (this.jXs.jTq) {
            lVar.a(1, this.jXr.getString(i.game_share_timeline), h.bottomsheet_icon_moment);
        }
    }
}
