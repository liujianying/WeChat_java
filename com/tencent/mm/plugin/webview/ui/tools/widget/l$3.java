package com.tencent.mm.plugin.webview.ui.tools.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class l$3 implements OnDismissListener {
    final /* synthetic */ l qlo;

    l$3(l lVar) {
        this.qlo = lVar;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        if (this.qlo.fyr != null) {
            this.qlo.fyr.setAdapter(null);
        }
    }
}
