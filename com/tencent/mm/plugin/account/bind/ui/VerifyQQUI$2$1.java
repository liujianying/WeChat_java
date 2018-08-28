package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.bind.a.b;
import com.tencent.mm.plugin.account.bind.ui.VerifyQQUI.2;

class VerifyQQUI$2$1 implements OnCancelListener {
    final /* synthetic */ b eJt;
    final /* synthetic */ 2 eJu;

    VerifyQQUI$2$1(2 2, b bVar) {
        this.eJu = 2;
        this.eJt = bVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eJt);
    }
}
