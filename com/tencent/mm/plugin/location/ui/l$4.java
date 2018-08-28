package com.tencent.mm.plugin.location.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class l$4 implements OnClickListener {
    final /* synthetic */ l kGP;

    l$4(l lVar) {
        this.kGP = lVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.kGP.kGO != null) {
            this.kGP.kGO.aZN();
        }
    }
}
