package com.tencent.mm.plugin.fts.ui;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.e;
import com.tencent.mm.plugin.fts.a.d.e.b;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.plugin.fts.ui.d.f;
import com.tencent.mm.sdk.platformtools.ag;
import java.util.HashSet;

public final class g extends d implements b {
    private ag jvE = new ag(Looper.getMainLooper());
    private f jwv;
    private boolean jww;

    public g(e eVar, String str, int i) {
        super(eVar);
        Context context = eVar.getContext();
        HashSet hashSet = new HashSet();
        hashSet.add(Integer.valueOf(160));
        f fVar = (f) ((n) com.tencent.mm.kernel.g.n(n.class)).createFTSUIUnitList(hashSet, context, this, i).get(0);
        fVar.jso = str;
        if (s.fq(str)) {
            fVar.jwq = ((com.tencent.mm.plugin.chatroom.b.b) com.tencent.mm.kernel.g.l(com.tencent.mm.plugin.chatroom.b.b.class)).Ga().ih(str);
        }
        this.jwv = fVar;
    }

    public final void a(e eVar, String str) {
        setCount(eVar.qg(0));
        notifyDataSetChanged();
        J(getCount(), true);
    }

    protected final a qh(int i) {
        a qh = this.jwv.qh(i);
        if (qh != null) {
            qh.jtl = i;
            qh.pageType = 4;
        }
        return qh;
    }

    protected final void aQx() {
        this.jww = false;
        this.jwv.a(this.bWm, this.jvE, new HashSet());
    }

    protected final boolean a(View view, a aVar, boolean z) {
        this.jwv.a(view, aVar, z);
        if (aVar.jts && !this.jww) {
            this.jww = true;
            k.c(this.bWm, true, this.jwv.aQw(), -2);
        }
        return false;
    }

    public final void finish() {
        super.finish();
        if (!this.jww) {
            this.jww = true;
            k.c(this.bWm, false, this.jwv.aQw(), -2);
        }
    }

    protected final int aQg() {
        return this.jwv.aQw();
    }
}
