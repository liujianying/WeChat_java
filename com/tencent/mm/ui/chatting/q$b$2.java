package com.tencent.mm.ui.chatting;

import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.ui.chatting.q.b;

class q$b$2 implements a {
    final /* synthetic */ b tJI;

    q$b$2(b bVar) {
        this.tJI = bVar;
    }

    public final boolean vD() {
        if (!(b.d(this.tJI) == null || b.e(this.tJI) == null)) {
            b.e(this.tJI).showAsDropDown(b.d(this.tJI), b.f(this.tJI), b.g(this.tJI));
        }
        return false;
    }
}
