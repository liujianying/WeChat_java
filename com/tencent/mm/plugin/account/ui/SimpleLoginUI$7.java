package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;

class SimpleLoginUI$7 implements OnDismissListener {
    final /* synthetic */ SimpleLoginUI eXn;

    SimpleLoginUI$7(SimpleLoginUI simpleLoginUI) {
        this.eXn = simpleLoginUI;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        SimpleLoginUI.i(this.eXn);
    }
}
