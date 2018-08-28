package com.tencent.mm.plugin.card.ui;

class CardGiftImageUI$7 implements Runnable {
    final /* synthetic */ CardGiftImageUI hDo;

    CardGiftImageUI$7(CardGiftImageUI cardGiftImageUI) {
        this.hDo = cardGiftImageUI;
    }

    public final void run() {
        if (CardGiftImageUI.f(this.hDo).getVisibility() != 0) {
            CardGiftImageUI.f(this.hDo).setVisibility(0);
        }
    }
}
