package com.tencent.mm.ui.chatting.g;

import android.view.MenuItem;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.ui.base.n$d;
import com.tencent.mm.ui.chatting.a.b.b;
import com.tencent.mm.ui.chatting.g.d.2;

class d$2$2 implements n$d {
    final /* synthetic */ b tXY;
    final /* synthetic */ 2 tYn;

    d$2$2(2 2, b bVar) {
        this.tYn = 2;
        this.tXY = bVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        au.HU();
        this.tYn.tYl.d(i, c.FT().dW(this.tXY.bJC));
    }
}
