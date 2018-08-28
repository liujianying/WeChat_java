package com.tencent.mm.plugin.account.bind.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class VerifyQQUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ VerifyQQUI eJq;

    VerifyQQUI$1(VerifyQQUI verifyQQUI) {
        this.eJq = verifyQQUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.eJq.YC();
        VerifyQQUI.a(this.eJq);
        return true;
    }
}
