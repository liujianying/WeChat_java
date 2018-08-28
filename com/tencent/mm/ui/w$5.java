package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.ui.base.b;

class w$5 implements OnCancelListener {
    final /* synthetic */ Activity ews;
    final /* synthetic */ Intent tnx = null;

    w$5(Activity activity) {
        this.ews = activity;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        h.mEJ.a(405, 39, 1, true);
        if (this.tnx != null) {
            this.ews.finish();
            this.ews.startActivity(this.tnx);
            b.E(this.ews, this.tnx);
        }
    }
}
