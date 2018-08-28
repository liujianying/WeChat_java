package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class f$4 implements OnClickListener {
    final /* synthetic */ f eJe;

    f$4(f fVar) {
        this.eJe = fVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.eJe.eIW = null;
        this.eJe.onDetach();
        this.eJe.Xd();
    }
}
