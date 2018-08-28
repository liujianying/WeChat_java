package com.tencent.mm.plugin.location.ui.impl;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class i$7 implements OnCancelListener {
    final /* synthetic */ i kKy;

    i$7(i iVar) {
        this.kKy = iVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.kKy.kHV = false;
    }
}
