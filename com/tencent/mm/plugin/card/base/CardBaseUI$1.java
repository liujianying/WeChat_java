package com.tencent.mm.plugin.card.base;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CardBaseUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ CardBaseUI htt;

    CardBaseUI$1(CardBaseUI cardBaseUI) {
        this.htt = cardBaseUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.htt.finish();
        return true;
    }
}
