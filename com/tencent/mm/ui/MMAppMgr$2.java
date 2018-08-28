package com.tencent.mm.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.sdk.platformtools.x;

class MMAppMgr$2 implements OnClickListener {
    final /* synthetic */ Context val$context;

    MMAppMgr$2(Context context) {
        this.val$context = context;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        try {
            this.val$context.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        } catch (Throwable e) {
            x.printErrStackTrace("MicroMsg.MMAppMgr", e, "showLbsTipsAlert", new Object[0]);
        }
    }
}
