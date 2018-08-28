package com.tencent.mm.ui.f.a;

import android.view.View;
import android.view.View.OnClickListener;

class f$1 implements OnClickListener {
    final /* synthetic */ f utE;

    f$1(f fVar) {
        this.utE = fVar;
    }

    public final void onClick(View view) {
        f.a(this.utE).onCancel();
        this.utE.dismiss();
    }
}
