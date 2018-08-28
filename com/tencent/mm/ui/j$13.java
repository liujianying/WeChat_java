package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class j$13 implements OnClickListener {
    final /* synthetic */ j tjf;

    j$13(j jVar) {
        this.tjf = jVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.tjf.mRz.setText("");
        this.tjf.eJi.dismiss();
    }
}
