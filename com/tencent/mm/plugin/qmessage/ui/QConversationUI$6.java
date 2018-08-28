package com.tencent.mm.plugin.qmessage.ui;

import android.view.View;
import com.tencent.mm.ui.base.MMSlideDelView$c;

class QConversationUI$6 implements MMSlideDelView$c {
    final /* synthetic */ QConversationUI mbV;

    QConversationUI$6(QConversationUI qConversationUI) {
        this.mbV = qConversationUI;
    }

    public final int cl(View view) {
        return QConversationUI.c(this.mbV).getPositionForView(view);
    }
}
