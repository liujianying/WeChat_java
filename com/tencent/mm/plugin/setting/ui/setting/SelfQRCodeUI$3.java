package com.tencent.mm.plugin.setting.ui.setting;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SelfQRCodeUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ SelfQRCodeUI mQy;

    SelfQRCodeUI$3(SelfQRCodeUI selfQRCodeUI) {
        this.mQy = selfQRCodeUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.mQy.YC();
        this.mQy.finish();
        return true;
    }
}
