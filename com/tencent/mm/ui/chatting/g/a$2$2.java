package com.tencent.mm.ui.chatting.g;

import android.view.MenuItem;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.a.b.b;
import com.tencent.mm.ui.chatting.g.a.2;

class a$2$2 implements d {
    final /* synthetic */ 2 tXX;
    final /* synthetic */ b tXY;

    a$2$2(2 2, b bVar) {
        this.tXX = 2;
        this.tXY = bVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        au.HU();
        this.tXX.tXW.d(menuItem.getItemId(), c.FT().dW(this.tXY.bJC));
    }
}
