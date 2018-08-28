package com.tencent.mm.plugin.card.ui;

class CardGiftImageUI$8 implements Runnable {
    final /* synthetic */ String ewx;
    final /* synthetic */ CardGiftImageUI hDo;

    CardGiftImageUI$8(CardGiftImageUI cardGiftImageUI, String str) {
        this.hDo = cardGiftImageUI;
        this.ewx = str;
    }

    public final void run() {
        if (CardGiftImageUI.f(this.hDo).getVisibility() != 8) {
            CardGiftImageUI.f(this.hDo).setVisibility(8);
        }
        CardGiftImageUI.a(this.hDo, this.ewx);
        CardGiftImageUI.g(this.hDo);
        CardGiftImageUI.h(this.hDo).notifyDataSetChanged();
    }
}
