package com.tencent.mm.ui.chatting.gallery;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class AppBrandHistoryListUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ AppBrandHistoryListUI tTw;

    AppBrandHistoryListUI$1(AppBrandHistoryListUI appBrandHistoryListUI) {
        this.tTw = appBrandHistoryListUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.tTw.finish();
        return true;
    }
}
