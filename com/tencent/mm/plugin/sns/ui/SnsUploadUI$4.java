package com.tencent.mm.plugin.sns.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class SnsUploadUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ SnsUploadUI ogU;

    SnsUploadUI$4(SnsUploadUI snsUploadUI) {
        this.ogU = snsUploadUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        SnsUploadUI.l(this.ogU);
        return true;
    }
}
