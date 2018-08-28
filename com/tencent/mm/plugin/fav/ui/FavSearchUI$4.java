package com.tencent.mm.plugin.fav.ui;

import com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView;

class FavSearchUI$4 implements Runnable {
    final /* synthetic */ FavSearchUI iZQ;

    FavSearchUI$4(FavSearchUI favSearchUI) {
        this.iZQ = favSearchUI;
    }

    public final void run() {
        FavSearchActionView a = FavSearchUI.a(this.iZQ);
        if (a.jat != null) {
            a.jat.crO();
        }
        this.iZQ.showVKB();
    }
}
