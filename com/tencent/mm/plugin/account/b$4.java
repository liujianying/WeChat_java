package com.tencent.mm.plugin.account;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.q.b;

class b$4 extends a {
    final /* synthetic */ b eEO;

    b$4(b bVar) {
        this.eEO = bVar;
    }

    public final boolean execute() {
        com.tencent.mm.q.a aVar = new com.tencent.mm.q.a();
        ((n) g.n(n.class)).registerIndexStorage(aVar);
        aVar.create();
        b bVar = new b();
        ((n) g.n(n.class)).registerNativeLogic(9, bVar);
        bVar.create();
        ((n) g.n(n.class)).registerFTSUILogic(new com.tencent.mm.q.a.a());
        return true;
    }

    public final String getName() {
        return "InitFTSFriendPluginTask";
    }
}
