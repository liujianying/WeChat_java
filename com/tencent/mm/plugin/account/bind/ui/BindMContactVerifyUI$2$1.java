package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.bind.ui.BindMContactVerifyUI.2;
import com.tencent.mm.plugin.account.friend.a.x;

class BindMContactVerifyUI$2$1 implements OnCancelListener {
    final /* synthetic */ x eGH;
    final /* synthetic */ 2 eGI;

    BindMContactVerifyUI$2$1(2 2, x xVar) {
        this.eGI = 2;
        this.eGH = xVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eGH);
    }
}
