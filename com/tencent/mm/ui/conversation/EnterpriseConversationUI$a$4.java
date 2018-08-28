package com.tencent.mm.ui.conversation;

import android.view.MenuItem;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.conversation.EnterpriseConversationUI.a;

class EnterpriseConversationUI$a$4 implements d {
    final /* synthetic */ a uqA;

    EnterpriseConversationUI$a$4(a aVar) {
        this.uqA = aVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                a.a(this.uqA, a.g(this.uqA));
                return;
            case 2:
                a.b(this.uqA, a.g(this.uqA));
                return;
            case 3:
                a.aaS(a.g(this.uqA));
                return;
            default:
                return;
        }
    }
}
