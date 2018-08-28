package com.tencent.mm.plugin.account.security.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SecurityAccountIntroUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ SecurityAccountIntroUI ePa;

    SecurityAccountIntroUI$3(SecurityAccountIntroUI securityAccountIntroUI) {
        this.ePa = securityAccountIntroUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        SecurityAccountIntroUI.e(this.ePa);
        return true;
    }
}
