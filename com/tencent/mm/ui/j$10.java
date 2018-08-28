package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.modelsimple.r;

class j$10 implements OnCancelListener {
    final /* synthetic */ j tjf;
    final /* synthetic */ r tjn;

    j$10(j jVar, r rVar) {
        this.tjf = jVar;
        this.tjn = rVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.tjn);
    }
}
