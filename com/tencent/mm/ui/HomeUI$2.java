package com.tencent.mm.ui;

class HomeUI$2 implements Runnable {
    final /* synthetic */ HomeUI tjS;

    HomeUI$2(HomeUI homeUI) {
        this.tjS = homeUI;
    }

    public final void run() {
        HomeUI.d(this.tjS).supportInvalidateOptionsMenu();
    }

    public final String toString() {
        return super.toString() + "|supportInvalidateOptionsMenu";
    }
}
