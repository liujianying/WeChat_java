package com.tencent.mm.ui.i;

import android.view.View;
import android.view.View.OnClickListener;

class b$1 implements OnClickListener {
    final /* synthetic */ b uFq;

    b$1(b bVar) {
        this.uFq = bVar;
    }

    public final void onClick(View view) {
        b.a(this.uFq).onCancel();
        this.uFq.dismiss();
    }
}
