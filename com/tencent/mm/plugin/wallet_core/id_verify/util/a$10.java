package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

class a$10 implements OnCancelListener {
    final /* synthetic */ Activity ews;
    final /* synthetic */ boolean plf;

    a$10(boolean z, Activity activity) {
        this.plf = z;
        this.ews = activity;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.plf) {
            this.ews.finish();
        }
    }
}
