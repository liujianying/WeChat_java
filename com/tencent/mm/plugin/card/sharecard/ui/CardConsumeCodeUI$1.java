package com.tencent.mm.plugin.card.sharecard.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class CardConsumeCodeUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ CardConsumeCodeUI hzo;

    CardConsumeCodeUI$1(CardConsumeCodeUI cardConsumeCodeUI) {
        this.hzo = cardConsumeCodeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.hzo.setResult(-1);
        this.hzo.finish();
        return true;
    }
}
