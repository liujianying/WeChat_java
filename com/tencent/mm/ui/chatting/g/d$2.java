package com.tencent.mm.ui.chatting.g;

import android.view.View;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.a.b.b;
import com.tencent.mm.ui.chatting.a.b.e;
import com.tencent.mm.ui.tools.k;

class d$2 implements e {
    final /* synthetic */ d tYl;

    d$2(d dVar) {
        this.tYl = dVar;
    }

    public final void a(int i, b bVar) {
        x.i("MicroMsg.FileHistoryListPresenter", "[onItemClick] position:%s", new Object[]{Integer.valueOf(i)});
        d.a(this.tYl, bVar);
    }

    public final void a(View view, int i, b bVar) {
        x.i("MicroMsg.FileHistoryListPresenter", "[onItemLongClick] position:%s", new Object[]{Integer.valueOf(i)});
        new k(view.getContext()).b(view, new 1(this), new 2(this, bVar));
    }
}
