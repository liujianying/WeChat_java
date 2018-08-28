package com.tencent.mm.plugin.card.ui;

import android.database.Cursor;
import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.n;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.aa.a;

class CardHomePageUI$9 implements IdleHandler {
    final /* synthetic */ CardHomePageUI hEJ;

    CardHomePageUI$9(CardHomePageUI cardHomePageUI) {
        this.hEJ = cardHomePageUI;
    }

    public final boolean queueIdle() {
        if (CardHomePageUI.h(this.hEJ) != null) {
            boolean z;
            CardHomePageUI.h(this.hEJ);
            Integer num = (Integer) g.Ei().DT().get(a.USERINFO_CARD_HAS_UPDATE_CARD_TYPE_INT_SYNC, Integer.valueOf(0));
            if (num == null || num.intValue() != 1) {
                g.Ei().DT().a(a.USERINFO_CARD_HAS_UPDATE_CARD_TYPE_INT_SYNC, Integer.valueOf(1));
                Cursor nH = am.axi().nH(n.a.hwN);
                if (nH == null || nH.getCount() <= 0) {
                    x.e("MicroMsg.ShareCardDataMgr", "updateAllCardInfoByBlockField cursor is null or size is 0");
                    z = false;
                } else {
                    nH.moveToFirst();
                    while (!nH.isAfterLast()) {
                        CardInfo cardInfo = new CardInfo();
                        cardInfo.d(nH);
                        if (cardInfo.field_card_type == -1) {
                            if (cardInfo.awm() == null) {
                                x.e("MicroMsg.ShareCardDataMgr", "updateCardType fail , info.getCardTpInfo() == null");
                            } else {
                                cardInfo.field_card_type = cardInfo.awm().huV;
                                if (!am.axi().c(cardInfo, new String[0])) {
                                    x.e("MicroMsg.ShareCardDataMgr", "updateCardType fail , cardId = %s", cardInfo.field_card_id);
                                }
                            }
                        }
                        nH.moveToNext();
                    }
                    nH.close();
                    z = true;
                }
            } else {
                z = false;
            }
            if (z) {
                x.i("MicroMsg.CardHomePageUI", "try2UpdateCardType");
                CardHomePageUI.i(this.hEJ);
            }
        }
        return false;
    }
}
