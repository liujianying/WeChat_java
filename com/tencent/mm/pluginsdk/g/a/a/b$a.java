package com.tencent.mm.pluginsdk.g.a.a;

import com.tencent.mm.model.bv.a;
import com.tencent.mm.plugin.messenger.foundation.a.o;
import com.tencent.mm.pluginsdk.g.a.c.g;
import com.tencent.mm.pluginsdk.g.a.c.h;
import com.tencent.mm.pluginsdk.g.a.c.l;
import com.tencent.mm.pluginsdk.g.a.c.n;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;

public final class b$a implements g {
    private final a pTc = new 2(this);
    private final c qCa = new 1(this);
    private final h qCb = new h();

    public final void bUO() {
        com.tencent.mm.sdk.b.a.sFg.b(this.qCa);
        ((o) com.tencent.mm.kernel.g.n(o.class)).getSysCmdMsgExtension().a("resourcemgr", this.pTc, true);
        com.tencent.mm.kernel.g.Em().h(new 3(this), 10000);
    }

    public final void onAccountRelease() {
        com.tencent.mm.sdk.b.a.sFg.c(this.qCa);
        ((o) com.tencent.mm.kernel.g.n(o.class)).getSysCmdMsgExtension().b("resourcemgr", this.pTc, true);
    }

    public final String aca() {
        return "CheckResUpdate";
    }

    public final n.a c(l lVar) {
        if (lVar instanceof c) {
            x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "return CheckResUpdateNetworkRequestHandler");
            return new d((c) lVar);
        }
        x.i("MicroMsg.ResDownloader.CheckResUpdateHelper", "get mismatch NetworkRequest type, return null");
        return null;
    }

    public final h bUP() {
        return this.qCb;
    }
}
