package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a$a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.m;
import com.tencent.mm.plugin.fts.ui.n.g;
import com.tencent.mm.sdk.platformtools.x;

public class n extends a {
    public String jyK;
    private b jyL = new b(this);
    private a jyM = new a(this);

    public n(int i) {
        super(12, i);
    }

    public final void a(Context context, a$a a_a, Object... objArr) {
        if (m.qm(this.jtk) == null) {
            this.jyK = "";
        } else {
            this.jyK = context.getResources().getString(g.search_contact_button_find_more, new Object[]{r0});
        }
        x.i("MicroMsg.FTS.FTSMoreDataItem", "fillDataItem: tip=%s", new Object[]{this.jyK});
    }

    public b BV() {
        return this.jyL;
    }

    public a$a afD() {
        return this.jyM;
    }
}
