package com.tencent.mm.plugin.appbrand.f;

import com.tencent.mm.kernel.g;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.e.j.a;
import com.tencent.mm.sdk.platformtools.x;

public final class b extends com.tencent.mm.plugin.fts.a.b {
    m dhW;
    c fyF;
    private a fyG = new 1(this);

    public final com.tencent.mm.plugin.fts.a.a.a a(i iVar) {
        return this.dhW.a(-65536, new c(this, iVar));
    }

    protected final boolean onCreate() {
        if (((n) g.n(n.class)).isFTSContextReady()) {
            x.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "Create Success!");
            this.fyF = (c) ((n) g.n(n.class)).getFTSIndexStorage(WXMediaMessage.TITLE_LENGTH_LIMIT);
            this.dhW = ((n) g.n(n.class)).getFTSTaskDaemon();
            this.dhW.a(65616, new d(this));
            i.onCreate();
            i.e(this.fyG);
            return true;
        }
        x.i("MicroMsg.FTS.FTS5SearchWeAppLogic", "Create Fail!");
        return false;
    }

    protected final boolean BT() {
        i.onDestroy();
        i.f(this.fyG);
        this.fyF = null;
        this.dhW = null;
        return true;
    }

    public final String getName() {
        return "FTS5SearchWeAppLogic";
    }
}
