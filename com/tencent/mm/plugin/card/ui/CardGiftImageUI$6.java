package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.tools.f.b;

class CardGiftImageUI$6 implements b {
    final /* synthetic */ CardGiftImageUI hDo;

    CardGiftImageUI$6(CardGiftImageUI cardGiftImageUI) {
        this.hDo = cardGiftImageUI;
    }

    public final void onAnimationStart() {
    }

    public final void onAnimationEnd() {
        new ag().post(new 1(this));
    }
}
