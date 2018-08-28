package com.tencent.mm.plugin.qmessage.ui;

import android.view.MenuItem;
import com.tencent.mm.ui.base.n.d;

class QConversationUI$5 implements d {
    final /* synthetic */ QConversationUI mbV;

    QConversationUI$5(QConversationUI qConversationUI) {
        this.mbV = qConversationUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        QConversationUI.a(this.mbV, QConversationUI.j(this.mbV));
    }
}
