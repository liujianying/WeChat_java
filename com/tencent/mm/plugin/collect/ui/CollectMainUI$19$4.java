package com.tencent.mm.plugin.collect.ui;

import android.view.MenuItem;
import com.tencent.mm.plugin.collect.ui.CollectMainUI.19;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.n$d;

class CollectMainUI$19$4 implements n$d {
    final /* synthetic */ 19 hYW;

    CollectMainUI$19$4(19 19) {
        this.hYW = 19;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                CollectMainUI.e(this.hYW.hYN);
                return;
            case 1:
                if (CollectMainUI.d(this.hYW.hYN) != null) {
                    CollectMainUI.cn(CollectMainUI.d(this.hYW.hYN).username, CollectMainUI.d(this.hYW.hYN).rWY);
                    h.mEJ.h(15387, new Object[]{Integer.valueOf(1)});
                    return;
                }
                return;
            default:
                return;
        }
    }
}
