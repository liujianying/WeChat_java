package com.tencent.mm.pluginsdk.ui.preference;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.pluginsdk.model.m;

class a$2 implements OnCancelListener {
    final /* synthetic */ m lYl;
    final /* synthetic */ a qOu;

    a$2(a aVar, m mVar) {
        this.qOu = aVar;
        this.lYl = mVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.lYl);
    }
}
