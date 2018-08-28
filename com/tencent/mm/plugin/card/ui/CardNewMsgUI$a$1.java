package com.tencent.mm.plugin.card.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.plugin.card.model.g.a;
import com.tencent.mm.plugin.card.sharecard.ui.CardConsumeSuccessUI;
import com.tencent.mm.plugin.report.service.h;

class CardNewMsgUI$a$1 implements OnClickListener {
    final /* synthetic */ a hFP;
    final /* synthetic */ g hFQ;
    final /* synthetic */ CardNewMsgUI.a hFR;

    CardNewMsgUI$a$1(CardNewMsgUI.a aVar, a aVar2, g gVar) {
        this.hFR = aVar;
        this.hFP = aVar2;
        this.hFQ = gVar;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        if (this.hFP.hwF == 0) {
            intent.setClass(this.hFR.hFN.mController.tml, CardDetailUI.class);
            intent.putExtra("key_card_id", this.hFP.cardId);
            intent.putExtra("key_card_ext", this.hFP.hwD);
            intent.putExtra("key_from_scene", 17);
            this.hFR.hFN.startActivity(intent);
        } else if (this.hFP.hwF == 1) {
            intent.setClass(this.hFR.hFN.mController.tml, CardConsumeSuccessUI.class);
            intent.putExtra("key_card_id", this.hFQ.field_card_id);
            intent.putExtra("key_from_scene", 2);
            this.hFR.hFN.startActivity(intent);
        }
        h.mEJ.h(11941, new Object[]{Integer.valueOf(8), this.hFQ.field_card_id, this.hFQ.field_card_tp_id, this.hFQ.field_msg_id, this.hFP.cardId});
    }
}
