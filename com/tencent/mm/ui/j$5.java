package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.sdk.platformtools.ah;

class j$5 implements OnClickListener {
    final /* synthetic */ j tjf;

    j$5(j jVar) {
        this.tjf = jVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        ah.A(new 1(this, dialogInterface));
    }
}
