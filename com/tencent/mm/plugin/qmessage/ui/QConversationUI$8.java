package com.tencent.mm.plugin.qmessage.ui;

import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.MMSlideDelView.f;

class QConversationUI$8 implements f {
    final /* synthetic */ QConversationUI mbV;

    QConversationUI$8(QConversationUI qConversationUI) {
        this.mbV = qConversationUI;
    }

    public final void bv(Object obj) {
        if (obj == null) {
            x.e("MicroMsg.QConversationUI", "onItemDel object null");
        } else {
            QConversationUI.a(this.mbV, obj.toString());
        }
    }
}
