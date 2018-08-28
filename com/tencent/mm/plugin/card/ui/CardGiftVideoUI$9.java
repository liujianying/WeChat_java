package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.ui.tools.f.b;

class CardGiftVideoUI$9 implements b {
    final /* synthetic */ CardGiftVideoUI hEs;

    CardGiftVideoUI$9(CardGiftVideoUI cardGiftVideoUI) {
        this.hEs = cardGiftVideoUI;
    }

    public final void onAnimationStart() {
    }

    public final void onAnimationEnd() {
        new ag().post(new 1(this));
    }
}
