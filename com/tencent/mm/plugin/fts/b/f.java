package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.ab.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.b;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.x;
import java.util.List;

public final class f extends b {
    private e dKj = new 2(this);
    m dhW;
    c juU = new 1(this);
    String[] juV;
    List<String> juW;

    public final String getName() {
        return "SearchTestLogic";
    }

    protected final boolean onCreate() {
        if (((n) g.n(n.class)).isFTSContextReady()) {
            x.i("MicroMsg.FTS.FTSSearchTestLogic", "Create Success!");
            this.dhW = ((n) g.n(n.class)).getFTSTaskDaemon();
            this.juU.cht();
            return true;
        }
        x.i("MicroMsg.FTS.FTSSearchTestLogic", "Create Fail!");
        return false;
    }

    public final a a(i iVar) {
        a fVar;
        switch (iVar.jsn) {
            case 65521:
                fVar = new f(this, iVar.jss);
                break;
            case 65523:
                fVar = new e(this, iVar);
                break;
            case 65524:
                fVar = new d(this, (byte) 0);
                break;
            default:
                fVar = new a(this, (byte) 0);
                break;
        }
        return this.dhW.a(-65536, fVar);
    }

    protected final boolean BT() {
        g.DF().b(30, this.dKj);
        return false;
    }
}
