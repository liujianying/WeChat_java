package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;

class BindFacebookUI$1 implements OnCancelListener {
    final /* synthetic */ BindFacebookUI ePD;

    BindFacebookUI$1(BindFacebookUI bindFacebookUI) {
        this.ePD = bindFacebookUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (BindFacebookUI.a(this.ePD) != null) {
            g.DF().c(BindFacebookUI.a(this.ePD));
        }
    }
}
