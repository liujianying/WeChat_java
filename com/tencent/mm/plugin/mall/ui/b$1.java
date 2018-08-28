package com.tencent.mm.plugin.mall.ui;

import android.view.View;
import android.view.View.OnClickListener;

class b$1 implements OnClickListener {
    final /* synthetic */ b kYI;

    b$1(b bVar) {
        this.kYI = bVar;
    }

    public final void onClick(View view) {
        b.a(this.kYI, !b.a(this.kYI));
        b.b(this.kYI);
        this.kYI.notifyDataSetChanged();
    }
}
