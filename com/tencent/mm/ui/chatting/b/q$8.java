package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class q$8 implements OnClickListener {
    final /* synthetic */ q tPX;

    q$8(q qVar) {
        this.tPX = qVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.tPX.bAG.tTq.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
