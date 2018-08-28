package com.tencent.mm.plugin.game.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class c$3 implements OnClickListener {
    final /* synthetic */ c jTV;

    c$3(c cVar) {
        this.jTV = cVar;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        this.jTV.mContext.startActivity(new Intent("android.settings.SECURITY_SETTINGS"));
        dialogInterface.cancel();
    }
}
