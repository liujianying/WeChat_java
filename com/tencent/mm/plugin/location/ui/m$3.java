package com.tencent.mm.plugin.location.ui;

import android.view.View;
import android.view.View.OnClickListener;

class m$3 implements OnClickListener {
    final /* synthetic */ m kHj;

    m$3(m mVar) {
        this.kHj = mVar;
    }

    public final void onClick(View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        m.a(this.kHj, iArr[0], iArr[1]);
    }
}
