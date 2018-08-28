package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;

class FacebookLoginUI$5 implements OnCancelListener {
    final /* synthetic */ FacebookLoginUI eQv;

    FacebookLoginUI$5(FacebookLoginUI facebookLoginUI) {
        this.eQv = facebookLoginUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        if (FacebookLoginUI.b(this.eQv) != null) {
            g.DF().c(FacebookLoginUI.b(this.eQv));
        }
    }
}
