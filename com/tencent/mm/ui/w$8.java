package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.ui.base.b;

class w$8 implements OnClickListener {
    final /* synthetic */ Activity ews;
    final /* synthetic */ Intent tnx;

    w$8(Intent intent, Activity activity) {
        this.tnx = intent;
        this.ews = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
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
