package com.tencent.mm.plugin.b;

import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.a.d;
import com.tencent.mm.model.a.g;
import com.tencent.mm.model.p;
import com.tencent.mm.plugin.messenger.foundation.a.o;

public final class a extends p implements c {
    private static a eEu;
    private d eEv = new d();
    private com.tencent.mm.model.a.a eEw = new com.tencent.mm.model.a.a();

    private a() {
        super(g.class);
    }

    public static synchronized a WB() {
        a aVar;
        synchronized (a.class) {
            if (eEu == null) {
                eEu = new a();
            }
            aVar = eEu;
        }
        return aVar;
    }

    public final void onAccountInitialized(e.c cVar) {
        super.onAccountInitialized(cVar);
        com.tencent.mm.ab.d.c.a(Integer.valueOf(-1879048184), this.eEv);
        ((o) com.tencent.mm.kernel.g.n(o.class)).getSysCmdMsgExtension().a("abtest", this.eEw);
    }

    public final void onAccountRelease() {
        super.onAccountRelease();
        com.tencent.mm.ab.d.c.a(Integer.valueOf(-1879048184), this.eEv);
        ((o) com.tencent.mm.kernel.g.n(o.class)).getSysCmdMsgExtension().b("abtest", this.eEw);
    }
}
