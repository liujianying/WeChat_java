package com.tencent.mm.plugin.nearby.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.nearby.ui.a.4;

class a$4$1 implements OnCancelListener {
    final /* synthetic */ 4 lBJ;

    a$4$1(4 4) {
        this.lBJ = 4;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(a.c(this.lBJ.lBI));
    }
}
