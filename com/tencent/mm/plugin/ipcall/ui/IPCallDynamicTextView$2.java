package com.tencent.mm.plugin.ipcall.ui;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class IPCallDynamicTextView$2 implements OnGlobalLayoutListener {
    final /* synthetic */ IPCallDynamicTextView kvJ;

    IPCallDynamicTextView$2(IPCallDynamicTextView iPCallDynamicTextView) {
        this.kvJ = iPCallDynamicTextView;
    }

    public final void onGlobalLayout() {
        if (IPCallDynamicTextView.b(this.kvJ) != IPCallDynamicTextView.c(this.kvJ)) {
            IPCallDynamicTextView.e(this.kvJ).sendEmptyMessage(1);
        }
    }
}
