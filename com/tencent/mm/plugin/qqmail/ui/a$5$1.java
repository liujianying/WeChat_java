package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.qqmail.b.n;
import com.tencent.mm.plugin.qqmail.ui.a.5;

class a$5$1 implements OnCancelListener {
    final /* synthetic */ n mfZ;
    final /* synthetic */ 5 mgb;

    a$5$1(5 5, n nVar) {
        this.mgb = 5;
        this.mfZ = nVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.mfZ);
    }
}
