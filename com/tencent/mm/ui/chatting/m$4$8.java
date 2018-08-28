package com.tencent.mm.ui.chatting;

import android.view.MenuItem;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.m.4;

class m$4$8 implements d {
    final /* synthetic */ String dMs;
    final /* synthetic */ 4 tIT;

    m$4$8(4 4, String str) {
        this.tIT = 4;
        this.dMs = str;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (menuItem.getItemId() == 0) {
            m.ctg().tIV = true;
        } else {
            m.ctg().tIV = false;
        }
        m.a(this.dMs, this.tIT.tIQ, this.tIT.tIF);
    }
}
