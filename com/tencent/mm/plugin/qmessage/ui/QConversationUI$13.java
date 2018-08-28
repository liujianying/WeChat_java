package com.tencent.mm.plugin.qmessage.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.sdk.platformtools.bi;

class QConversationUI$13 implements OnMenuItemClickListener {
    final /* synthetic */ QConversationUI mbV;

    QConversationUI$13(QConversationUI qConversationUI) {
        this.mbV = qConversationUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (!bi.oW(QConversationUI.f(this.mbV))) {
            QConversationUI.a(this.mbV, QConversationUI.f(this.mbV), QConversationUI.g(this.mbV));
        }
        return true;
    }
}
