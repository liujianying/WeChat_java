package com.tencent.mm.plugin.card.ui;

import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;

class CardDetailBaseUI$1 implements OnClickListener {
    final /* synthetic */ OnMenuItemClickListener hBy;
    final /* synthetic */ CardDetailBaseUI hBz;

    CardDetailBaseUI$1(CardDetailBaseUI cardDetailBaseUI, OnMenuItemClickListener onMenuItemClickListener) {
        this.hBz = cardDetailBaseUI;
        this.hBy = onMenuItemClickListener;
    }

    public final void onClick(View view) {
        if (this.hBy != null) {
            this.hBy.onMenuItemClick(null);
        }
    }
}
