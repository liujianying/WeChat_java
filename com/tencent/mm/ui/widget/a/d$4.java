package com.tencent.mm.ui.widget.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class d$4 implements OnDismissListener {
    final /* synthetic */ d uKm;

    d$4(d dVar) {
        this.uKm = dVar;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        if (!d.m(this.uKm)) {
            this.uKm.uJQ.onDismiss();
        }
    }
}
