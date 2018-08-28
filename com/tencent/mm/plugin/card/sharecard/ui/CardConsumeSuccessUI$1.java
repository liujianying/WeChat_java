package com.tencent.mm.plugin.card.sharecard.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CardConsumeSuccessUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ CardConsumeSuccessUI hzG;

    CardConsumeSuccessUI$1(CardConsumeSuccessUI cardConsumeSuccessUI) {
        this.hzG = cardConsumeSuccessUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.hzG.finish();
        CardConsumeSuccessUI.axP();
        return true;
    }
}
