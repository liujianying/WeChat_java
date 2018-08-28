package com.tencent.mm.plugin.ipcall.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class j$6 implements OnClickListener {
    final /* synthetic */ j kzY;

    j$6(j jVar) {
        this.kzY = jVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.kzY.kzN.finish();
        this.kzY.kzN = null;
    }
}
