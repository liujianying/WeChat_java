package com.tencent.mm.plugin.webview.ui.tools;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;

class OAuthUI$6 implements OnMenuItemClickListener {
    final /* synthetic */ OAuthUI pVZ;

    OAuthUI$6(OAuthUI oAuthUI) {
        this.pVZ = oAuthUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        if (OAuthUI.b(this.pVZ) != null) {
            OAuthUI.b(this.pVZ);
        }
        this.pVZ.mhH.stopLoading();
        this.pVZ.M(false, false);
        OAuthUI.c(this.pVZ);
        return false;
    }
}
