package com.tencent.mm.ui.conversation;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SettingCheckUnProcessWalletConvUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SettingCheckUnProcessWalletConvUI urE;

    SettingCheckUnProcessWalletConvUI$1(SettingCheckUnProcessWalletConvUI settingCheckUnProcessWalletConvUI) {
        this.urE = settingCheckUnProcessWalletConvUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.urE.finish();
        return false;
    }
}
