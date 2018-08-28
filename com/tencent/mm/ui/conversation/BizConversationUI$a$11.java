package com.tencent.mm.ui.conversation;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.conversation.BizConversationUI.a;

class BizConversationUI$a$11 implements OnMenuItemClickListener {
    final /* synthetic */ a unz;

    BizConversationUI$a$11(a aVar) {
        this.unz = aVar;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.unz.finish();
        return true;
    }
}
