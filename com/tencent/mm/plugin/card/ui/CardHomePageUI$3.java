package com.tencent.mm.plugin.card.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CardHomePageUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ CardHomePageUI hEJ;

    CardHomePageUI$3(CardHomePageUI cardHomePageUI) {
        this.hEJ = cardHomePageUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (CardHomePageUI.a(this.hEJ) == 1 || CardHomePageUI.a(this.hEJ) == 2) {
            CardHomePageUI.b(this.hEJ);
        } else {
            this.hEJ.finish();
        }
        return true;
    }
}
