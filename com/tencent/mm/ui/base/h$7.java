package com.tencent.mm.ui.base;

import android.view.MenuItem;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.base.n.d;

class h$7 implements d {
    final /* synthetic */ c ttw;

    h$7(c cVar) {
        this.ttw = cVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (this.ttw != null) {
            this.ttw.ju(menuItem.getItemId());
        }
    }
}
