package com.tencent.mm.model.gdpr.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class MPGdprPolicyUI$3 implements OnMenuItemClickListener {
    final /* synthetic */ MPGdprPolicyUI dEr;

    MPGdprPolicyUI$3(MPGdprPolicyUI mPGdprPolicyUI) {
        this.dEr = mPGdprPolicyUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.dEr.finish();
        return true;
    }
}
