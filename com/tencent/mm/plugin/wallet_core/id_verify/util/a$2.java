package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class a$2 implements OnDismissListener {
    final /* synthetic */ Activity ews;
    final /* synthetic */ boolean plf;

    a$2(boolean z, Activity activity) {
        this.plf = z;
        this.ews = activity;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        if (this.plf) {
            this.ews.finish();
        }
    }
}
