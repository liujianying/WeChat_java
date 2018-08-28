package com.tencent.mm.ui;

import android.view.View;
import android.view.View.OnClickListener;

class ag$1 implements OnClickListener {
    final /* synthetic */ ag tpY;

    ag$1(ag agVar) {
        this.tpY = agVar;
    }

    public final void onClick(View view) {
        if (ag.a(this.tpY) != null) {
            ag.a(this.tpY).onClickBackBtn(view);
        }
    }
}
