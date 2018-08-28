package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.chatroom.b.b;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.c.e;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.a.d;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.storage.u;

public final class f extends d implements l {
    private ag giD = new ag();
    private j jsk;
    private String jso;
    private a jsw;
    private u jwq;

    public f(e eVar, String str) {
        super(eVar);
        this.jso = str;
        if (s.fq(str)) {
            this.jwq = ((b) g.l(b.class)).Ga().ih(str);
        }
    }

    protected final com.tencent.mm.plugin.fts.a.d.a.a qh(int i) {
        d dVar = new d(i);
        dVar.fyJ = (com.tencent.mm.plugin.fts.a.a.l) this.jsk.jsx.get(i);
        dVar.jrx = this.jsk.jrx;
        dVar.jtk = -14;
        dVar.jwq = this.jwq;
        dVar.jtl = i;
        dVar.pageType = 6;
        if (dVar.position == getCount() - 1) {
            dVar.jtj = true;
        }
        return dVar;
    }

    protected final void aQx() {
        clearCache();
        if (this.jsw != null) {
            ((n) g.n(n.class)).cancelSearchTask(this.jsw);
        }
        i iVar = new i();
        iVar.bWm = this.bWm;
        iVar.jso = this.jso;
        iVar.jsu = e.jsX;
        iVar.jsv = this;
        iVar.handler = this.giD;
        iVar.jsn = 3;
        this.jsw = ((n) g.n(n.class)).search(3, iVar);
        x.i("MicroMSsg.FTS.FTSChattingConvAdapter", "do search %s", new Object[]{this.bWm});
    }

    public final void b(j jVar) {
        switch (jVar.bjW) {
            case -3:
            case -2:
            case -1:
                setCount(0);
                notifyDataSetChanged();
                J(getCount(), true);
                return;
            case 0:
                this.jsk = jVar;
                setCount(jVar.jsx.size());
                notifyDataSetChanged();
                J(getCount(), true);
                return;
            default:
                return;
        }
    }

    public final void finish() {
        super.finish();
        if (this.jsw != null) {
            ((n) g.n(n.class)).cancelSearchTask(this.jsw);
        }
    }

    protected final boolean a(View view, com.tencent.mm.plugin.fts.a.d.a.a aVar, boolean z) {
        return false;
    }
}
