package com.tencent.mm.plugin.qmessage.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class b$6 implements OnClickListener {
    final /* synthetic */ b mbL;

    b$6(b bVar) {
        this.mbL = bVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b.m(this.mbL.context, false);
    }
}
