package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.x;

class GameDetailUI2$16 implements OnClickListener {
    final /* synthetic */ GameDetailUI2 jXr;

    GameDetailUI2$16(GameDetailUI2 gameDetailUI2) {
        this.jXr = gameDetailUI2;
    }

    public final void onClick(View view) {
        if (GameDetailUI2.l(this.jXr) == null) {
            x.e("MicroMsg.GameDetailUI2", "Null appInfo");
        } else if (GameDetailUI2.i(this.jXr) == null) {
            x.e("MicroMsg.GameDetailUI2", "No DownloadInfo found");
        } else {
            GameDetailUI2.i(this.jXr).dC(this.jXr.mController.tml);
            GameDetailUI2.m(this.jXr).a(GameDetailUI2.l(this.jXr), GameDetailUI2.i(this.jXr));
        }
    }
}
