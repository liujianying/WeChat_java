package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;

class FacebookAuthUI$3 implements OnCancelListener {
    final /* synthetic */ FacebookAuthUI eQg;

    FacebookAuthUI$3(FacebookAuthUI facebookAuthUI) {
        this.eQg = facebookAuthUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (FacebookAuthUI.a(this.eQg) != null) {
            g.DF().c(FacebookAuthUI.a(this.eQg));
        }
    }
}
