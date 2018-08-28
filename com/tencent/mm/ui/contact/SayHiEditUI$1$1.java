package com.tencent.mm.ui.contact;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.ui.contact.SayHiEditUI.1;

class SayHiEditUI$1$1 implements OnCancelListener {
    final /* synthetic */ m lYl;
    final /* synthetic */ 1 ulr;

    SayHiEditUI$1$1(1 1, m mVar) {
        this.ulr = 1;
        this.lYl = mVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.lYl);
    }
}
