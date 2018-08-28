package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.view.View.OnFocusChangeListener;

class c$7 implements OnFocusChangeListener {
    final /* synthetic */ c kJf;

    c$7(c cVar) {
        this.kJf = cVar;
    }

    public final void onFocusChange(View view, boolean z) {
        if (z) {
            this.kJf.showVKB();
        }
    }
}
