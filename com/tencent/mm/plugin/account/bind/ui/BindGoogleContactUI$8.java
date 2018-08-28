package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;

class BindGoogleContactUI$8 implements OnCancelListener {
    final /* synthetic */ BindGoogleContactUI eFm;

    BindGoogleContactUI$8(BindGoogleContactUI bindGoogleContactUI) {
        this.eFm = bindGoogleContactUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        BindGoogleContactUI.f(this.eFm);
        if (BindGoogleContactUI.g(this.eFm) != null) {
            g.DF().c(BindGoogleContactUI.g(this.eFm));
        }
    }
}
