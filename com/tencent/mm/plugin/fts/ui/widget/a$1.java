package com.tencent.mm.plugin.fts.ui.widget;

import android.view.View;
import android.view.View.OnClickListener;

class a$1 implements OnClickListener {
    final /* synthetic */ a jzZ;

    a$1(a aVar) {
        this.jzZ = aVar;
    }

    public final void onClick(View view) {
        if (a.a(this.jzZ) != null) {
            a.a(this.jzZ).onClickBackBtn(view);
        }
    }
}
