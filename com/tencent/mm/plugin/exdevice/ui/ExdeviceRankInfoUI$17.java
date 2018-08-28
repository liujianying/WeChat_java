package com.tencent.mm.plugin.exdevice.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.exdevice.f.b.c;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.ui.base.n.d;

class ExdeviceRankInfoUI$17 implements d {
    final /* synthetic */ ExdeviceRankInfoUI iFG;

    ExdeviceRankInfoUI$17(ExdeviceRankInfoUI exdeviceRankInfoUI) {
        this.iFG = exdeviceRankInfoUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (i) {
            case 0:
                ExdeviceRankInfoUI.a(this.iFG, true);
                com.tencent.mm.plugin.sport.b.d.kB(10);
                ad.aHm();
                c.c("", ExdeviceRankInfoUI.x(this.iFG), ExdeviceRankInfoUI.y(this.iFG).field_username, 3);
                return;
            default:
                return;
        }
    }
}
