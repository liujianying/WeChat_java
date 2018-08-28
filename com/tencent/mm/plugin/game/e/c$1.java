package com.tencent.mm.plugin.game.e;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class c$1 implements OnCancelListener {
    final /* synthetic */ Dialog kdj;

    c$1(Dialog dialog) {
        this.kdj = dialog;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.kdj.setOnCancelListener(null);
    }
}
