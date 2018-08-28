package com.tencent.mm.plugin.nearby.ui;

import android.view.MenuItem;
import com.tencent.mm.ui.base.n.d;

class NearbySayHiListUI$3 implements d {
    final /* synthetic */ NearbySayHiListUI lCB;

    NearbySayHiListUI$3(NearbySayHiListUI nearbySayHiListUI) {
        this.lCB = nearbySayHiListUI;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        com.tencent.mm.az.d.SG().YP(String.valueOf(NearbySayHiListUI.h(this.lCB)));
        NearbySayHiListUI.b(this.lCB).a(null, null);
        if (NearbySayHiListUI.c(this.lCB) > 0) {
            NearbySayHiListUI.i(this.lCB);
        }
        NearbySayHiListUI.j(this.lCB);
    }
}
