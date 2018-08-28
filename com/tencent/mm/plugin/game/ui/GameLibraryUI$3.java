package com.tencent.mm.plugin.game.ui;

class GameLibraryUI$3 implements m$a {
    final /* synthetic */ GameLibraryUI jZN;

    GameLibraryUI$3(GameLibraryUI gameLibraryUI) {
        this.jZN = gameLibraryUI;
    }

    public final void qS(int i) {
        int firstVisiblePosition = GameLibraryUI.b(this.jZN).getFirstVisiblePosition() - GameLibraryUI.c(this.jZN);
        int lastVisiblePosition = GameLibraryUI.b(this.jZN).getLastVisiblePosition() - GameLibraryUI.c(this.jZN);
        if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
            GameLibraryUI.d(this.jZN).y(GameLibraryUI.b(this.jZN).getChildAt(i - firstVisiblePosition), i);
        }
    }
}
