package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.account.friend.a.w;

class BindGoogleContactUI$4 implements OnClickListener {
    final /* synthetic */ BindGoogleContactUI eFm;
    final /* synthetic */ String eFn;

    BindGoogleContactUI$4(BindGoogleContactUI bindGoogleContactUI, String str) {
        this.eFm = bindGoogleContactUI;
        this.eFn = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        BindGoogleContactUI.a(this.eFm, this.eFn, w.eKF);
    }
}
