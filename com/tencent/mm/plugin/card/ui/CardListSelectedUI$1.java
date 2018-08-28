package com.tencent.mm.plugin.card.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CardListSelectedUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ CardListSelectedUI hFs;

    CardListSelectedUI$1(CardListSelectedUI cardListSelectedUI) {
        this.hFs = cardListSelectedUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.hFs.setResult(0);
        CardListSelectedUI.a(this.hFs, "");
        this.hFs.finish();
        return true;
    }
}
