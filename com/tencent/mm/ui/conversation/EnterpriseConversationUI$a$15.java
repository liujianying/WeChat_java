package com.tencent.mm.ui.conversation;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.conversation.EnterpriseConversationUI.a;
import com.tencent.mm.ui.g;
import com.tencent.mm.ui.tools.l;

class EnterpriseConversationUI$a$15 implements OnMenuItemClickListener {
    final /* synthetic */ a uqA;

    EnterpriseConversationUI$a$15(a aVar) {
        this.uqA = aVar;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (a.d(this.uqA) != null) {
            a.d(this.uqA).dismiss();
            a.a(this.uqA, null);
        }
        a.a(this.uqA, new l(this.uqA.getContext()));
        a.d(this.uqA).ofp = new 1(this);
        a.d(this.uqA).ofq = new 2(this);
        a.d(this.uqA).dZ();
        g.di(a.c(this.uqA), 1);
        return false;
    }
}
