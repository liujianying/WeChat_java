package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.bind.a.b;
import com.tencent.mm.plugin.account.bind.ui.VerifyQQUI.4;

class VerifyQQUI$4$1 implements OnCancelListener {
    final /* synthetic */ b eJt;
    final /* synthetic */ 4 eJv;

    VerifyQQUI$4$1(4 4, b bVar) {
        this.eJv = 4;
        this.eJt = bVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eJt);
    }
}
