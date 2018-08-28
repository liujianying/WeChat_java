package com.tencent.mm.plugin.webview.ui.tools;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class WebViewUI$42 implements OnMenuItemClickListener {
    final /* synthetic */ WebViewUI pZJ;

    WebViewUI$42(WebViewUI webViewUI) {
        this.pZJ = webViewUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Intent intent = new Intent();
        intent.setClassName(this.pZJ, "com.tencent.mm.plugin.setting.ui.fixtools.FixToolsUI");
        intent.putExtra("entry_fix_tools", 1);
        this.pZJ.startActivity(intent);
        return true;
    }
}
