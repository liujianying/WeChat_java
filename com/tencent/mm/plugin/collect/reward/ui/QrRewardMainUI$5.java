package com.tencent.mm.plugin.collect.reward.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n.d;

class QrRewardMainUI$5 implements d {
    final /* synthetic */ QrRewardMainUI hWf;

    QrRewardMainUI$5(QrRewardMainUI qrRewardMainUI) {
        this.hWf = qrRewardMainUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                QrRewardMainUI.a(this.hWf, "");
                QrRewardMainUI.n(this.hWf);
                QrRewardMainUI.c(this.hWf, true);
                h.mEJ.h(14721, new Object[]{Integer.valueOf(1), Integer.valueOf(3)});
                return;
            case 2:
                QrRewardMainUI.c(this.hWf, false);
                QrRewardMainUI.o(this.hWf);
                h.mEJ.h(14721, new Object[]{Integer.valueOf(1), Integer.valueOf(4)});
                return;
            default:
                x.i("MicroMsg.QrRewardMainUI", "unknown menu: %s", new Object[]{Integer.valueOf(menuItem.getItemId())});
                QrRewardMainUI.c(this.hWf, true);
                return;
        }
    }
}
