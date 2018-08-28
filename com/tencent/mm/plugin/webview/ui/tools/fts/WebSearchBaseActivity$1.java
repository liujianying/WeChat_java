package com.tencent.mm.plugin.webview.ui.tools.fts;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WebSearchBaseActivity$1 implements OnMenuItemClickListener {
    final /* synthetic */ WebSearchBaseActivity qfy;

    WebSearchBaseActivity$1(WebSearchBaseActivity webSearchBaseActivity) {
        this.qfy = webSearchBaseActivity;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qfy.finish();
        return true;
    }
}
