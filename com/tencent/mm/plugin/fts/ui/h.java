package com.tencent.mm.plugin.fts.ui;

import android.view.View;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e$b;
import com.tencent.mm.plugin.fts.ui.d.g;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.HashSet;

public final class h extends d implements e$b {
    private ag giD = new ag();
    private boolean jww;
    private g jwz;

    public h(e eVar, String str, String str2, String str3, int i, int i2) {
        super(eVar);
        this.jwz = new g(eVar.getContext(), this, i);
        this.jwz.jsp = str2;
        this.jwz.talker = str;
        this.jwz.jso = str3;
        this.jwz.showType = i2;
    }

    protected final a qh(int i) {
        a qh = this.jwz.qh(i);
        if (qh != null) {
            qh.pageType = 5;
        }
        return qh;
    }

    protected final void aQx() {
        this.jww = false;
        this.jwz.a(this.bWm, this.giD, new HashSet());
    }

    protected final boolean a(View view, a aVar, boolean z) {
        boolean a = this.jwz.a(view, aVar, z);
        if (aVar.jts && !this.jww) {
            this.jww = true;
            k.c(this.bWm, true, this.jwz.aQw(), -2);
        }
        if (a) {
            clearCache();
            setCount(this.jwz.qg(0));
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
            k.c(this.bWm, false, this.jwz.aQw(), -2);
        }
    }

    protected final int aQg() {
        return this.jwz.aQw();
    }
}
