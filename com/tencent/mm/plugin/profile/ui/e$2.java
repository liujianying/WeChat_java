package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class e$2 implements OnCancelListener {
    final /* synthetic */ e lVZ;

    e$2(e eVar) {
        this.lVZ = eVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.lVZ.isDeleteCancel = true;
    }
}
