package com.tencent.mm.ui.chatting.viewitems;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.model.au;
import com.tencent.mm.modelappbrand.q;
import com.tencent.mm.ui.chatting.viewitems.s.1.2;

class s$1$2$2 implements OnCancelListener {
    final /* synthetic */ 2 ucq;
    final /* synthetic */ q ucs;

    s$1$2$2(2 2, q qVar) {
        this.ucq = 2;
        this.ucs = qVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        au.DF().c(this.ucs);
    }
}
