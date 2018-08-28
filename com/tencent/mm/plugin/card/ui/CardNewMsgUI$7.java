package com.tencent.mm.plugin.card.ui;

import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.plugin.card.model.g;
import com.tencent.mm.ui.base.h.c;

class CardNewMsgUI$7 implements c {
    final /* synthetic */ int eKj;
    final /* synthetic */ CardNewMsgUI hFN;

    CardNewMsgUI$7(CardNewMsgUI cardNewMsgUI, int i) {
        this.hFN = cardNewMsgUI;
        this.eKj = i;
    }

    public final void ju(int i) {
        switch (i) {
            case 0:
                g gVar = (g) CardNewMsgUI.a(this.hFN).getItem(this.eKj);
                if (gVar != null) {
                    am.axm().xj(gVar.field_msg_id);
                    CardNewMsgUI.g(this.hFN);
                    CardNewMsgUI.a(this.hFN).a(null, null);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
