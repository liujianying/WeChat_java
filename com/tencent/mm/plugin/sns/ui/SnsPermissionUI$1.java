package com.tencent.mm.plugin.sns.ui;

import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SnsPermissionUI$1 implements OnMenuItemClickListener {
    final /* synthetic */ SnsPermissionUI nZu;

    SnsPermissionUI$1(SnsPermissionUI snsPermissionUI) {
        this.nZu = snsPermissionUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        this.nZu.YC();
        this.nZu.setResult(-1, new Intent());
        this.nZu.finish();
        return true;
    }
}
