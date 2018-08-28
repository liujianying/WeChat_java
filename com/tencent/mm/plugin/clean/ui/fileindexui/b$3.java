package com.tencent.mm.plugin.clean.ui.fileindexui;

import android.view.View;
import com.tencent.mm.plugin.clean.ui.fileindexui.b.a;
import com.tencent.mm.ui.gridviewheaders.GridHeadersGridView.c;

class b$3 implements c {
    final /* synthetic */ b hRX;

    b$3(b bVar) {
        this.hRX = bVar;
    }

    public final void cq(View view) {
        b.a(this.hRX, (a) view.getTag());
        this.hRX.notifyDataSetChanged();
    }
}
