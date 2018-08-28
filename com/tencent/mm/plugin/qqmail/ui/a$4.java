package com.tencent.mm.plugin.qqmail.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.qqmail.b.n;

class a$4 implements OnCancelListener {
    final /* synthetic */ a mfY;
    final /* synthetic */ n mfZ;

    a$4(a aVar, n nVar) {
        this.mfY = aVar;
        this.mfZ = nVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.mfZ);
    }
}
