package com.tencent.mm.plugin.card.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CardNewMsgUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ CardNewMsgUI hFN;

    CardNewMsgUI$1(CardNewMsgUI cardNewMsgUI) {
        this.hFN = cardNewMsgUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.hFN.finish();
        return true;
    }
}
