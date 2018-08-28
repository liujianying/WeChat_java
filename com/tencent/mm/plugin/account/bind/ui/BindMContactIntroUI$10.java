package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.x;

class BindMContactIntroUI$10 implements OnCancelListener {
    final /* synthetic */ BindMContactIntroUI eGe;
    final /* synthetic */ x eGf;

    BindMContactIntroUI$10(BindMContactIntroUI bindMContactIntroUI, x xVar) {
        this.eGe = bindMContactIntroUI;
        this.eGf = xVar;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(this.eGf);
    }
}
