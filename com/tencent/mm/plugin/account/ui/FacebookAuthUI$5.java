package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a$j;
import com.tencent.mm.plugin.account.friend.a.y;

class FacebookAuthUI$5 implements OnClickListener {
    final /* synthetic */ FacebookAuthUI eQg;

    FacebookAuthUI$5(FacebookAuthUI facebookAuthUI) {
        this.eQg = facebookAuthUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        FacebookAuthUI.a(this.eQg, ProgressDialog.show(this.eQg, this.eQg.getString(a$j.app_tip), this.eQg.getString(a$j.facebook_auth_unbinding), true));
        FacebookAuthUI.d(this.eQg).setOnCancelListener(FacebookAuthUI.c(this.eQg));
        g.DF().a(new y(y.eKR), 0);
    }
}
