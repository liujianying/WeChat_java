package com.tencent.mm.plugin.offline.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class c$14 implements OnCancelListener {
    final /* synthetic */ c lLe;

    c$14(c cVar) {
        this.lLe = cVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.lLe.bld();
    }
}
