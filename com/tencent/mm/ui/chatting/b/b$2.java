package com.tencent.mm.ui.chatting.b;

import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.ui.chatting.b.b.g;

class b$2 implements a {
    final /* synthetic */ b tOb;

    b$2(b bVar) {
        this.tOb = bVar;
    }

    public final void a(String str, l lVar) {
        x.v("MicroMsg.ChattingUI.AppMsgComponent", "app info watcher notify");
        ((g) this.tOb.bAG.O(g.class)).ctG();
    }
}
