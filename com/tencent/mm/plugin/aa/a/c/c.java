package com.tencent.mm.plugin.aa.a.c;

import com.tencent.mm.model.q;
import com.tencent.mm.plugin.aa.a.h;
import com.tencent.mm.sdk.platformtools.bi;
import com.tencent.mm.vending.app.a;

public class c extends a {
    static /* synthetic */ a a(c cVar) {
        String stringExtra = cVar.uPN.getStringExtra("chatroom");
        if (bi.oW(stringExtra)) {
            return null;
        }
        a aVar = new a(cVar);
        aVar.dhI = h.pb(stringExtra);
        if (aVar.dhI == null || aVar.dhI.size() <= 0) {
            return aVar;
        }
        aVar.dhI.remove(q.GF());
        return aVar;
    }

    protected final void onCreate() {
        super.onCreate();
        a(a.class, new 1(this));
    }
}
