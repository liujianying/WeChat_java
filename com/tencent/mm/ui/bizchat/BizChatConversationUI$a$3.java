package com.tencent.mm.ui.bizchat;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.ui.bizchat.BizChatConversationUI.a;

class BizChatConversationUI$a$3 implements OnMenuItemClickListener {
    final /* synthetic */ a tEC;

    BizChatConversationUI$a$3(a aVar) {
        this.tEC = aVar;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.tEC.finish();
        return true;
    }
}
