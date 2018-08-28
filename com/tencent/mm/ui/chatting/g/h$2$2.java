package com.tencent.mm.ui.chatting.g;

import android.view.MenuItem;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.a.b.b;
import com.tencent.mm.ui.chatting.g.h.2;

class h$2$2 implements d {
    final /* synthetic */ int hW;
    final /* synthetic */ b tXY;
    final /* synthetic */ 2 tYK;

    h$2$2(2 2, b bVar, int i) {
        this.tYK = 2;
        this.tXY = bVar;
        this.hW = i;
    }

    public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
        if (this.tXY == null) {
            x.e("MicroMsg.UrlHistoryListPresenter", "item is null! position:%s", new Object[]{Integer.valueOf(this.hW)});
            return;
        }
        au.HU();
        this.tYK.tYI.d(i, c.FT().dW(this.tXY.bJC));
    }
}
