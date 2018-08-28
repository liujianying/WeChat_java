package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.compatible.f.b;

class p$5 implements OnClickListener {
    final /* synthetic */ p tJl;

    p$5(p pVar) {
        this.tJl = pVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        b.bu(p.e(this.tJl).tTq.getContext());
    }
}
