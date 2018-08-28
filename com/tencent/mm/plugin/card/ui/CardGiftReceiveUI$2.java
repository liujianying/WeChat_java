package com.tencent.mm.plugin.card.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CardGiftReceiveUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ CardGiftReceiveUI hEd;

    CardGiftReceiveUI$2(CardGiftReceiveUI cardGiftReceiveUI) {
        this.hEd = cardGiftReceiveUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.hEd.finish();
        return true;
    }
}
