package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.plugin.game.model.an;

class GameLibraryUI$5 implements OnClickListener {
    final /* synthetic */ GameLibraryUI jZN;

    GameLibraryUI$5(GameLibraryUI gameLibraryUI) {
        this.jZN = gameLibraryUI;
    }

    public final void onClick(View view) {
        c.a(view, this.jZN);
        an.a(this.jZN, 11, 1110, 999, 7, GameLibraryUI.e(this.jZN), null);
    }
}
