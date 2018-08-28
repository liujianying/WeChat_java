package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class x$3 implements OnClickListener {
    final /* synthetic */ x tQP;

    x$3(x xVar) {
        this.tQP = xVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.tQP.bAG.tTq.startActivity(new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS"));
    }
}
