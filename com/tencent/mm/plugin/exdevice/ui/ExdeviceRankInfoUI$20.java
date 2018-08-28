package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.ui.base.n.d;

class ExdeviceRankInfoUI$20 implements d {
    final /* synthetic */ ExdeviceRankInfoUI iFG;

    ExdeviceRankInfoUI$20(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        this.iFG = exdeviceRankInfoUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                com.tencent.mm.plugin.sport.b.d.kB(15);
                ExdeviceRankInfoUI.n(this.iFG);
                return;
            case 1:
                com.tencent.mm.plugin.sport.b.d.kB(16);
                ExdeviceRankInfoUI.m(this.iFG);
                return;
            case 2:
                com.tencent.mm.plugin.sport.b.d.kB(7);
                ExdeviceRankInfoUI.o(this.iFG);
                return;
            case 3:
                com.tencent.mm.plugin.sport.b.d.kB(36);
                AppBrandStatObject appBrandStatObject = new AppBrandStatObject();
                appBrandStatObject.scene = 1063;
                ((com.tencent.mm.plugin.appbrand.n.d) g.l(com.tencent.mm.plugin.appbrand.n.d.class)).a(null, "gh_1f9ebf140e39@app", null, 0, 0, null, appBrandStatObject);
                return;
            default:
                return;
        }
    }
}
