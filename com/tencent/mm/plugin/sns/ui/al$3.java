package com.tencent.mm.plugin.sns.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class al$3 implements OnCancelListener {
    final /* synthetic */ al nRJ;

    al$3(al alVar) {
        this.nRJ = alVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.nRJ.nOW = null;
    }
}
