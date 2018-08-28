package com.tencent.mm.ui.chatting.g;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.util.List;

class e$15 implements OnClickListener {
    final /* synthetic */ List tUK;
    final /* synthetic */ e tYu;

    e$15(e eVar, List list) {
        this.tYu = eVar;
        this.tUK = list;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        e.a(this.tYu, this.tUK);
    }
}
