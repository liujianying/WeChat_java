package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.bind.a.c;
import com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI.8.1;

class BindLinkedInUI$8$1$1 implements OnCancelListener {
    final /* synthetic */ c eFP;
    final /* synthetic */ 1 eFQ;

    BindLinkedInUI$8$1$1(1 1, c cVar) {
        this.eFQ = 1;
        this.eFP = cVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eFP);
    }
}
