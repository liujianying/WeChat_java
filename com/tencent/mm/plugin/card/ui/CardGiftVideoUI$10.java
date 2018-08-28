package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.smtt.utils.TbsLog;

class CardGiftVideoUI$10 implements a {
    final /* synthetic */ CardGiftVideoUI hEs;

    CardGiftVideoUI$10(CardGiftVideoUI cardGiftVideoUI) {
        this.hEs = cardGiftVideoUI;
    }

    public final boolean vD() {
        if (CardGiftVideoUI.e(this.hEs).isPlaying()) {
            CardGiftVideoUI cardGiftVideoUI = this.hEs;
            int currentPosition = CardGiftVideoUI.e(this.hEs).getCurrentPosition() / TbsLog.TBSLOG_CODE_SDK_BASE;
            if (cardGiftVideoUI.hEo != null && cardGiftVideoUI.duration > 0) {
                currentPosition = cardGiftVideoUI.duration - currentPosition;
                if (currentPosition < 0) {
                    currentPosition = 0;
                }
                cardGiftVideoUI.hEo.setText(currentPosition + "\"");
            }
        }
        return true;
    }
}
