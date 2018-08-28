package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a$a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bi;

public final class g extends m {
    private a jyf = new a(this);
    CharSequence jyg;

    public g(int i) {
        super(i);
    }

    public final b BV() {
        return this.jyf;
    }

    public final void a(Context context, a$a a_a, Object... objArr) {
        super.a(context, a_a, objArr);
        CharSequence Bc = d.Bc(this.fyJ.talker);
        if (bi.oW(Bc)) {
            Bc = d.Bc(this.fyJ.jrv);
        }
        this.jyg = j.b(context, Bc, (float) c.jvy);
    }
}
