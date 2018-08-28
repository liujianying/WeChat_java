package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class BindMobileUI$1 implements OnClickListener {
    final /* synthetic */ String eHf;
    final /* synthetic */ BindMobileUI eHg;

    BindMobileUI$1(BindMobileUI bindMobileUI, String str) {
        this.eHg = bindMobileUI;
        this.eHf = str;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        BindMobileUI.a(this.eHg, this.eHf);
    }
}
