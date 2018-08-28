package com.tencent.mm.plugin.game.ui;

import com.tencent.mm.plugin.game.model.an;
import com.tencent.mm.plugin.game.ui.GameDropdownView.a;
import com.tencent.mm.sdk.platformtools.x;
import java.util.LinkedList;

class GameLibraryUI$7 implements a {
    final /* synthetic */ GameLibraryUI jZN;

    GameLibraryUI$7(GameLibraryUI gameLibraryUI) {
        this.jZN = gameLibraryUI;
    }

    public final void qW(int i) {
        LinkedList linkedList = new LinkedList();
        linkedList.addAll(GameLibraryUI.f(this.jZN).keySet());
        if (i <= linkedList.size() - 1) {
            GameLibraryUI.a(this.jZN, ((Integer) linkedList.get(i)).intValue());
            x.i("MicroMsg.GameLibraryUI", "Selected SortType: %d", new Object[]{Integer.valueOf(GameLibraryUI.g(this.jZN))});
            GameLibraryUI.b(this.jZN, 0);
            GameLibraryUI.h(this.jZN);
            an.a(this.jZN, 11, 1111, GameLibraryUI.g(this.jZN) + GameLibraryUI.i(this.jZN), 2, GameLibraryUI.e(this.jZN), null);
        }
    }
}
