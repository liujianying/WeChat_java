package com.tencent.mm.ui.chatting.b;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.ac.a.x;
import com.tencent.mm.model.au;

class c$7 implements OnCancelListener {
    final /* synthetic */ x tFE;
    final /* synthetic */ c tOm;

    c$7(c cVar, x xVar) {
        this.tOm = cVar;
        this.tFE = xVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.tFE);
    }
}
