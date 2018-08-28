package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import com.tencent.mm.plugin.fts.a.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a$b;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.n$g;

public final class a extends com.tencent.mm.plugin.fts.a.d.a.a {
    public CharSequence jxv;
    private b jxw = new b(this);
    private a jxx = new a(this);

    public a(int i) {
        super(10, i);
    }

    public final void a(Context context, com.tencent.mm.plugin.fts.a.d.a.a.a aVar, Object... objArr) {
        this.jxv = f.a(context.getResources().getString(n$g.fts_find_comm_tip_prefix), "", d.b(this.jrx.jrV, this.jrx.jrV)).jrO;
    }

    public final a$b BV() {
        return this.jxw;
    }

    protected final com.tencent.mm.plugin.fts.a.d.a.a.a afD() {
        return this.jxx;
    }
}
