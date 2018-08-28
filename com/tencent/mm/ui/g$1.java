package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class g$1 implements OnClickListener {
    final /* synthetic */ int eeg;
    final /* synthetic */ String tif;
    final /* synthetic */ Context val$context;

    g$1(Context context, String str, int i) {
        this.val$context = context;
        this.tif = str;
        this.eeg = i;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.p(this.val$context, this.tif, this.eeg);
    }
}
