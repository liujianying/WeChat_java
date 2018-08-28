package com.tencent.mm.ui.chatting.g;

import android.view.MenuItem;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.a.b.b;
import com.tencent.mm.ui.chatting.g.f.2;

class f$2$2 implements d {
    final /* synthetic */ b tXY;
    final /* synthetic */ 2 tYC;

    f$2$2(2 2, b bVar) {
        this.tYC = 2;
        this.tXY = bVar;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        au.HU();
        this.tYC.tYA.d(i, c.FT().dW(this.tXY.bJC));
    }
}
