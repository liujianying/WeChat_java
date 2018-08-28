package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.HashSet;

public final class l extends d implements b {
    private ag giD = new ag();
    private boolean jww;
    private com.tencent.mm.plugin.fts.ui.d.l jxr;

    public l(e eVar, String str, int i) {
        super(eVar);
        this.jxr = new com.tencent.mm.plugin.fts.ui.d.l(eVar.getContext(), this, i);
        this.jxr.jsp = str;
    }

    protected final a qh(int i) {
        a qh = this.jxr.qh(i);
        if (qh != null) {
            qh.pageType = 3;
        }
        return qh;
    }

    protected final void aQx() {
        this.jww = false;
        this.jxr.a(this.bWm, this.giD, new HashSet());
    }

    protected final boolean a(View view, a aVar, boolean z) {
        boolean a = this.jxr.a(view, aVar, z);
        if (aVar.jts && !this.jww) {
            this.jww = true;
            k.c(this.bWm, true, this.jxr.aQw(), -2);
        }
        if (a) {
            clearCache();
            setCount(this.jxr.qg(0));
            notifyDataSetChanged();
            J(getCount(), true);
        }
        return a;
    }

    public final void a(e eVar, String str) {
        setCount(eVar.qg(0));
        notifyDataSetChanged();
        J(getCount(), true);
    }

    public final void finish() {
        super.finish();
        if (!this.jww) {
            this.jww = true;
            k.c(this.bWm, false, this.jxr.aQw(), -2);
        }
    }

    protected final int aQg() {
        return this.jxr.aQw();
    }
}
