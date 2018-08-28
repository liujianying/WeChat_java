package com.tencent.mm.ui.tools;

class AddFavoriteUI$1 implements Runnable {
    final /* synthetic */ AddFavoriteUI uvB;

    AddFavoriteUI$1(AddFavoriteUI addFavoriteUI) {
        this.uvB = addFavoriteUI;
    }

    public final void run() {
        AddFavoriteUI.a(this.uvB).sendEmptyMessage(0);
    }
}
