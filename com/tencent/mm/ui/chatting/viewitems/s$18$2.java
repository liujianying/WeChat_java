package com.tencent.mm.ui.chatting.viewitems;

import android.view.MenuItem;
import com.tencent.mm.ui.base.n$d;
import com.tencent.mm.ui.chatting.viewitems.s.18;

class s$18$2 implements n$d {
    final /* synthetic */ String qiU;
    final /* synthetic */ 18 ucF;

    s$18$2(18 18, String str) {
        this.ucF = 18;
        this.qiU = str;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        switch (menuItem.getItemId()) {
            case 0:
                s.a(this.ucF.ucn, true, this.ucF.ucz, this.qiU, this.ucF.dAs);
                return;
            case 1:
                s.a(this.ucF.ucn, false, this.ucF.ucz, this.qiU, this.ucF.dAs);
                return;
            default:
                return;
        }
    }
}
