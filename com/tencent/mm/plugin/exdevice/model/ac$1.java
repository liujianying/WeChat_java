package com.tencent.mm.plugin.exdevice.model;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class ac$1 implements OnCancelListener {
    final /* synthetic */ ac iwd;

    ac$1(ac acVar) {
        this.iwd = acVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.iwd.dJO = true;
    }
}
