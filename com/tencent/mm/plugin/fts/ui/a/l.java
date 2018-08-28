package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import com.tencent.mm.plugin.fts.a.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.f;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.n.g;

public final class l extends a {
    CharSequence jyB;
    private b jyC = new b(this);
    a.a jyD = new a(this);

    public l(int i) {
        super(18, i);
    }

    public final void a(Context context, a.a aVar, Object... objArr) {
        Object charSequence = TextUtils.ellipsize(this.jrx.jrV, c.jvz, 400.0f, TruncateAt.MIDDLE).toString();
        this.jyB = f.a(context.getString(g.search_contact_no_result_pre), context.getString(g.search_contact_no_result_post), d.b(charSequence, charSequence)).jrO;
    }

    public final b BV() {
        return this.jyC;
    }

    protected final a.a afD() {
        return this.jyD;
    }
}
