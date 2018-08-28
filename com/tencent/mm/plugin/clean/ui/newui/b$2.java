package com.tencent.mm.plugin.clean.ui.newui;

import android.view.View;
import com.tencent.mm.plugin.clean.ui.newui.b.a;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.c;

class b$2 implements c {
    final /* synthetic */ b hTn;

    b$2(b bVar) {
        this.hTn = bVar;
    }

    public final void cq(View view) {
        b.a(this.hTn, (a) view.getTag());
        this.hTn.notifyDataSetChanged();
    }
}
