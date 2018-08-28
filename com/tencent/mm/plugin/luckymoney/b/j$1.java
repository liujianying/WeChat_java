package com.tencent.mm.plugin.luckymoney.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class j$1 implements OnCancelListener {
    final /* synthetic */ j kQw;

    j$1(j jVar) {
        this.kQw = jVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        this.kQw.baT();
    }
}
