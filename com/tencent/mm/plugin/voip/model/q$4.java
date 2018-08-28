package com.tencent.mm.plugin.voip.model;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class q$4 implements OnClickListener {
    final /* synthetic */ String dhh;
    final /* synthetic */ Context val$context;

    q$4(Context context, String str) {
        this.val$context = context;
        this.dhh = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        q.bKN();
        i.bJI().aO(this.val$context, this.dhh);
    }
}
