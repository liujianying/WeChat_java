package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SelfQRCodeUI$2 implements OnMenuItemClickListener {
    final /* synthetic */ SelfQRCodeUI mQy;

    SelfQRCodeUI$2(SelfQRCodeUI selfQRCodeUI) {
        this.mQy = selfQRCodeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        SelfQRCodeUI.b(this.mQy);
        return true;
    }
}
