package com.tencent.mm.plugin.clean.ui.newui;

import android.view.View;
import android.view.View.OnClickListener;

class b$1 implements OnClickListener {
    final /* synthetic */ b hTn;
    final /* synthetic */ int hW;

    b$1(b bVar, int i) {
        this.hTn = bVar;
        this.hW = i;
    }

    public final void onClick(View view) {
        b.a(this.hTn, this.hW);
        this.hTn.notifyDataSetChanged();
    }
}
