package com.tencent.mm.ui.tools;

class AddFavoriteUI$9 implements Runnable {
    final /* synthetic */ AddFavoriteUI uvB;

    AddFavoriteUI$9(AddFavoriteUI addFavoriteUI) {
        this.uvB = addFavoriteUI;
    }

    public final void run() {
        AddFavoriteUI.c(this.uvB).sendEmptyMessage(0);
    }
}
