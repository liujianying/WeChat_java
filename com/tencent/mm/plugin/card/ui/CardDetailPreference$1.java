package com.tencent.mm.plugin.card.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CardDetailPreference$1 implements OnMenuItemClickListener {
    final /* synthetic */ CardDetailPreference hBB;

    CardDetailPreference$1(CardDetailPreference cardDetailPreference) {
        this.hBB = cardDetailPreference;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.hBB.finish();
        return true;
    }
}
