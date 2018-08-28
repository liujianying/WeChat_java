package com.tencent.mm.plugin.webview.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class z$c$5 implements OnClickListener {
    final /* synthetic */ z$d pRy;

    public z$c$5(z$d z_d) {
        this.pRy = z_d;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.pRy.goBack();
    }
}
