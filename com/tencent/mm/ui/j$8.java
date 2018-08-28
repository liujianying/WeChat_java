package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.protocal.b.a.a;

class j$8 implements OnClickListener {
    final /* synthetic */ j tjf;
    final /* synthetic */ a tjl;
    final /* synthetic */ int val$id;

    j$8(j jVar, int i, a aVar) {
        this.tjf = jVar;
        this.val$id = i;
        this.tjl = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        j.a(this.tjf, this.val$id, this.tjl.actionType, this.tjl.id, this.tjl.qXX);
        dialogInterface.dismiss();
    }
}
