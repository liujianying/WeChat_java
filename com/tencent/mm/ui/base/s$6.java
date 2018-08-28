package com.tencent.mm.ui.base;

import android.view.View;
import android.view.View.OnClickListener;

class s$6 implements OnClickListener {
    final /* synthetic */ o tym;
    final /* synthetic */ OnClickListener typ;

    s$6(o oVar, OnClickListener onClickListener) {
        this.tym = oVar;
        this.typ = onClickListener;
    }

    public final void onClick(View view) {
        this.tym.dismiss();
        if (this.typ != null) {
            this.typ.onClick(view);
        }
    }
}
