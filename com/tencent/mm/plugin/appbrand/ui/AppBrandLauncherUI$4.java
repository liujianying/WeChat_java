package com.tencent.mm.plugin.appbrand.ui;

import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.sdk.platformtools.ad;

class AppBrandLauncherUI$4 implements OnMenuItemClickListener {
    final /* synthetic */ AppBrandLauncherUI guG;

    AppBrandLauncherUI$4(AppBrandLauncherUI appBrandLauncherUI) {
        this.guG = appBrandLauncherUI;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        ((i) g.l(i.class)).a(ad.getContext(), new 1(this));
        return true;
    }
}
