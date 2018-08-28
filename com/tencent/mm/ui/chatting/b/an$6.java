package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class an$6 implements OnClickListener {
    final /* synthetic */ Intent heh;
    final /* synthetic */ an tTe;

    an$6(an anVar, Intent intent) {
        this.tTe = anVar;
        this.heh = intent;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        an.a(this.tTe, this.heh);
    }
}
