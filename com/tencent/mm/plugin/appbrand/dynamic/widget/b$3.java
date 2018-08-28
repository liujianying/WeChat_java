package com.tencent.mm.plugin.appbrand.dynamic.widget;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class b$3 implements OnDismissListener {
    final /* synthetic */ b fyx;

    b$3(b bVar) {
        this.fyx = bVar;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        if (this.fyx.fyr != null) {
            this.fyx.fyr.setAdapter(null);
        }
    }
}
