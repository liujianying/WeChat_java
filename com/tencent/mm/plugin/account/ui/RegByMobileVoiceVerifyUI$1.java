package com.tencent.mm.plugin.account.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class RegByMobileVoiceVerifyUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ RegByMobileVoiceVerifyUI eVO;

    RegByMobileVoiceVerifyUI$1(RegByMobileVoiceVerifyUI regByMobileVoiceVerifyUI) {
        this.eVO = regByMobileVoiceVerifyUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.eVO.YC();
        this.eVO.finish();
        return true;
    }
}
