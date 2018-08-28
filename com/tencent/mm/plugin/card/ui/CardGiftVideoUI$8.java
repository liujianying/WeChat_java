package com.tencent.mm.plugin.card.ui;

import android.view.ViewTreeObserver.OnPreDrawListener;

class CardGiftVideoUI$8 implements OnPreDrawListener {
    final /* synthetic */ CardGiftVideoUI hEs;

    CardGiftVideoUI$8(CardGiftVideoUI cardGiftVideoUI) {
        this.hEs = cardGiftVideoUI;
    }

    public final boolean onPreDraw() {
        CardGiftVideoUI.b(this.hEs).getViewTreeObserver().removeOnPreDrawListener(this);
        CardGiftVideoUI.d(this.hEs).a(CardGiftVideoUI.b(this.hEs), CardGiftVideoUI.c(this.hEs), null);
        return true;
    }
}
