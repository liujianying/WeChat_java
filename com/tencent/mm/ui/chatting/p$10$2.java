package com.tencent.mm.ui.chatting;

import android.view.MenuItem;
import com.tencent.mm.ui.base.n$d;
import com.tencent.mm.ui.chatting.p.10;

class p$10$2 implements n$d {
    final /* synthetic */ 10 tJn;

    p$10$2(10 10) {
        this.tJn = 10;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 1:
                this.tJn.tJl.bny();
                return;
            case 2:
                this.tJn.tJl.bnz();
                return;
            default:
                return;
        }
    }
}
