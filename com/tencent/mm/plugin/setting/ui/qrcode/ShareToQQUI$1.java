package com.tencent.mm.plugin.setting.ui.qrcode;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class ShareToQQUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ ShareToQQUI mPF;

    ShareToQQUI$1(ShareToQQUI shareToQQUI) {
        this.mPF = shareToQQUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mPF.YC();
        this.mPF.finish();
        return true;
    }
}
