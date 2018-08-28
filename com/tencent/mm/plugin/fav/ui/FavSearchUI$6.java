package com.tencent.mm.plugin.fav.ui;

import android.support.v4.view.m;
import android.support.v7.widget.Toolbar.LayoutParams;

class FavSearchUI$6 implements Runnable {
    final /* synthetic */ FavSearchUI iZQ;

    FavSearchUI$6(FavSearchUI favSearchUI) {
        this.iZQ = favSearchUI;
    }

    public final void run() {
        if (FavSearchUI.b(this.iZQ) != null) {
            m.b(FavSearchUI.b(this.iZQ));
            LayoutParams layoutParams = (LayoutParams) FavSearchUI.a(this.iZQ).getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = -1;
                layoutParams.width = -1;
            }
            FavSearchUI.a(this.iZQ).setLayoutParams(layoutParams);
        }
    }
}
