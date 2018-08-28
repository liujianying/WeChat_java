package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ShareToQQWeiboUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ShareToQQWeiboUI qkz;

    ShareToQQWeiboUI$1(ShareToQQWeiboUI shareToQQWeiboUI) {
        this.qkz = shareToQQWeiboUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.qkz.YC();
        this.qkz.finish();
        return true;
    }
}
