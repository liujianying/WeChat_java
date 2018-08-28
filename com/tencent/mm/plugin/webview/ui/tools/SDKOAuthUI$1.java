package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SDKOAuthUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SDKOAuthUI pWs;

    SDKOAuthUI$1(SDKOAuthUI sDKOAuthUI) {
        this.pWs = sDKOAuthUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        SDKOAuthUI.a(this.pWs);
        this.pWs.finish();
        return true;
    }
}
