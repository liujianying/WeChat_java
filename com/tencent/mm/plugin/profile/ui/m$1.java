package com.tencent.mm.plugin.profile.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class m$1 implements OnClickListener {
    final /* synthetic */ m lWI;

    m$1(m mVar) {
        this.lWI = mVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.lWI.p(this.lWI.context, false);
    }
}
