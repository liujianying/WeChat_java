package com.tencent.mm.ui.bizchat;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.bizchat.BizChatConversationUI.a;
import com.tencent.mm.ui.tools.l;

class BizChatConversationUI$a$5 implements OnMenuItemClickListener {
    final /* synthetic */ a tEC;

    BizChatConversationUI$a$5(a aVar) {
        this.tEC = aVar;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (a.k(this.tEC) != null) {
            a.k(this.tEC).dismiss();
            a.a(this.tEC, null);
        }
        a.a(this.tEC, new l(this.tEC.getContext()));
        a.k(this.tEC).ofp = new 1(this);
        a.k(this.tEC).ofq = new 2(this);
        a.k(this.tEC).dZ();
        return false;
    }
}
