package com.tencent.mm.ui.voicesearch;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SearchConversationResultUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SearchConversationResultUI uFF;

    SearchConversationResultUI$2(SearchConversationResultUI searchConversationResultUI) {
        this.uFF = searchConversationResultUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.uFF.finish();
        return true;
    }
}
