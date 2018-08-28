package com.tencent.mm.plugin.qmessage.ui;

import com.tencent.mm.model.s;
import com.tencent.mm.model.t;
import com.tencent.mm.ui.r.a;

class QConversationUI$1 implements a {
    final /* synthetic */ QConversationUI mbV;

    QConversationUI$1(QConversationUI qConversationUI) {
        this.mbV = qConversationUI;
    }

    public final void Xb() {
        QConversationUI qConversationUI = this.mbV;
        String BK = QConversationUI.a(this.mbV).BK();
        int hX = t.hX(s.dAQ);
        if (hX <= 0) {
            qConversationUI.setMMTitle(BK);
        } else {
            qConversationUI.setMMTitle(BK + "(" + hX + ")");
        }
        QConversationUI.a(this.mbV, QConversationUI.b(this.mbV).getCount());
    }

    public final void Xa() {
    }
}
