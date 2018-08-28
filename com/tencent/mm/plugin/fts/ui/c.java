package com.tencent.mm.plugin.fts.ui;

import android.os.Looper;
import android.view.View;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.ui.d.a;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.HashSet;

public final class c extends d implements b {
    private a jvC;
    protected boolean jvD;
    private ag jvE = new ag(Looper.getMainLooper());

    public c(e eVar) {
        super(eVar);
        this.jvC = new a(eVar.getContext(), this, 0);
    }

    protected final com.tencent.mm.plugin.fts.a.d.a.a qh(int i) {
        return this.jvC.qh(i);
    }

    protected final void aQx() {
        this.jvD = false;
        this.jvC.a(this.bWm, this.jvE, new HashSet());
    }

    protected final boolean a(View view, com.tencent.mm.plugin.fts.a.d.a.a aVar, boolean z) {
        return false;
    }

    public final void a(e eVar, String str) {
        int qg = this.jvC.qg(0);
        setCount(qg);
        notifyDataSetChanged();
        J(qg, true);
    }

    protected final int aQg() {
        return this.jvC.aQw();
    }
}
