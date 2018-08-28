package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.ui.base.b;

class w$10 implements OnCancelListener {
    final /* synthetic */ Activity ews;
    final /* synthetic */ Intent tnx;

    w$10(Intent intent, Activity activity) {
        this.tnx = intent;
        this.ews = activity;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (this.tnx != null) {
            if (!(this.ews instanceof LauncherUI)) {
                this.ews.finish();
            }
            this.ews.startActivity(this.tnx);
            b.E(this.ews, this.tnx);
            x.ca(this.ews);
        }
    }
}
