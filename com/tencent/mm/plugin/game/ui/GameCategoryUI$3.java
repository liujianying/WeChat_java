package com.tencent.mm.plugin.game.ui;

class GameCategoryUI$3 implements m$a {
    final /* synthetic */ GameCategoryUI jUT;

    GameCategoryUI$3(GameCategoryUI gameCategoryUI) {
        this.jUT = gameCategoryUI;
    }

    public final void qS(int i) {
        int firstVisiblePosition = GameCategoryUI.b(this.jUT).getFirstVisiblePosition();
        int lastVisiblePosition = GameCategoryUI.b(this.jUT).getLastVisiblePosition();
        if (i >= firstVisiblePosition && i <= lastVisiblePosition) {
            GameCategoryUI.c(this.jUT).y(GameCategoryUI.b(this.jUT).getChildAt(i - firstVisiblePosition), i);
        }
    }
}
