package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.sdk.platformtools.bi;

class GameMessageUI$5 implements OnClickListener {
    final /* synthetic */ GameMessageUI kbc;

    GameMessageUI$5(GameMessageUI gameMessageUI) {
        this.kbc = gameMessageUI;
    }

    public final void onClick(View view) {
        if (!bi.oW(GameMessageUI.f(this.kbc))) {
            an.a(this.kbc.mController.tml, 13, 1302, 1, c.an(this.kbc.mController.tml, GameMessageUI.f(this.kbc)), GameMessageUI.g(this.kbc), null);
        }
        GameMessageUI.h(this.kbc);
    }
}
