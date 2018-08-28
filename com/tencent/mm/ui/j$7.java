package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.protocal.b.a.a;

class j$7 implements OnClickListener {
    final /* synthetic */ j tjf;
    final /* synthetic */ a tjk;
    final /* synthetic */ int val$id;

    j$7(j jVar, int i, a aVar) {
        this.tjf = jVar;
        this.val$id = i;
        this.tjk = aVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        j.a(this.tjf, this.val$id, this.tjk.actionType, this.tjk.id, this.tjk.qXX);
        dialogInterface.dismiss();
    }
}
