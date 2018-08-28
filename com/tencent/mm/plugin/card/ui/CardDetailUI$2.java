package com.tencent.mm.plugin.card.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CardDetailUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ CardDetailUI hBR;

    CardDetailUI$2(CardDetailUI cardDetailUI) {
        this.hBR = cardDetailUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        CardDetailUI.h(this.hBR);
        return true;
    }
}
