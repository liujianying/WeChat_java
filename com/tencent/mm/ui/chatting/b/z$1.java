package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.storage.bd;

class z$1 implements OnClickListener {
    final /* synthetic */ bd dAs;
    final /* synthetic */ z tRa;

    z$1(z zVar, bd bdVar) {
        this.tRa = zVar;
        this.dAs = bdVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        z.a(this.tRa, this.dAs);
    }
}
