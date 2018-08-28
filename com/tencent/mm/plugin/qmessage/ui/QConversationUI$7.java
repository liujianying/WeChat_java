package com.tencent.mm.plugin.qmessage.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMSlideDelView.g;

class QConversationUI$7 implements g {
    final /* synthetic */ QConversationUI mbV;

    QConversationUI$7(QConversationUI qConversationUI) {
        this.mbV = qConversationUI;
    }

    public final void t(View view, int i) {
        QConversationUI.c(this.mbV).performItemClick(view, i, 0);
    }
}
