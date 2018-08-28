package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.ah;
import com.tencent.mm.plugin.game.ui.GameCenterUI5.2;
import com.tencent.mm.sdk.platformtools.x;

class GameCenterUI5$2$1 implements Runnable {
    final /* synthetic */ ah jVG;
    final /* synthetic */ 2 jVH;

    GameCenterUI5$2$1(2 2, ah ahVar) {
        this.jVH = 2;
        this.jVG = ahVar;
    }

    public final void run() {
        try {
            GameCenterUI5.a(this.jVH.jVE, this.jVG, 2);
        } catch (Exception e) {
            x.e("MicroMsg.GameCenterUI5", "GameCenter crash, %s", new Object[]{e.getMessage()});
            this.jVH.jVE.finish();
        }
        if (GameCenterUI5.a(this.jVH.jVE) != null) {
            GameCenterUI5.a(this.jVH.jVE).dismiss();
        }
        x.i("MicroMsg.GameCenterUI5", "Server data parsing time: %d", new Object[]{Long.valueOf(System.currentTimeMillis() - this.jVH.cXh)});
    }
}
