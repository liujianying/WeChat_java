package com.tencent.mm.plugin.game.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class h$1 implements OnClickListener {
    final /* synthetic */ h jVJ;

    h$1(h hVar) {
        this.jVJ = hVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        h.a(this.jVJ);
        dialogInterface.dismiss();
    }
}
