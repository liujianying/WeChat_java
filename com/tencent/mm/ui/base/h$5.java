package com.tencent.mm.ui.base;

import android.view.MenuItem;
import com.tencent.mm.ui.base.n.d;

class h$5 implements d {
    final /* synthetic */ h.d ttv;

    h$5(h.d dVar) {
        this.ttv = dVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (this.ttv != null) {
            this.ttv.bx(i, menuItem.getItemId());
        }
    }
}
