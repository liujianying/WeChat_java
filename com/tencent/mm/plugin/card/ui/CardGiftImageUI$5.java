package com.tencent.mm.plugin.card.ui;

import android.view.ViewTreeObserver.OnPreDrawListener;

class CardGiftImageUI$5 implements OnPreDrawListener {
    final /* synthetic */ CardGiftImageUI hDo;

    CardGiftImageUI$5(CardGiftImageUI cardGiftImageUI) {
        this.hDo = cardGiftImageUI;
    }

    public final boolean onPreDraw() {
        CardGiftImageUI.c(this.hDo).getViewTreeObserver().removeOnPreDrawListener(this);
        CardGiftImageUI.e(this.hDo).a(CardGiftImageUI.c(this.hDo), CardGiftImageUI.d(this.hDo), null);
        return true;
    }
}
