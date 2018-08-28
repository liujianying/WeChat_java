package com.tencent.mm.plugin.qmessage.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class QConversationUI$11 implements OnMenuItemClickListener {
    final /* synthetic */ QConversationUI mbV;

    QConversationUI$11(QConversationUI qConversationUI) {
        this.mbV = qConversationUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        QConversationUI.e(this.mbV);
        return true;
    }
}
