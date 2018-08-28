package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.mm.kernel.g;

class BindGoogleContactIntroUI$4 implements OnCancelListener {
    final /* synthetic */ BindGoogleContactIntroUI eFc;

    BindGoogleContactIntroUI$4(BindGoogleContactIntroUI bindGoogleContactIntroUI) {
        this.eFc = bindGoogleContactIntroUI;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        g.DF().c(BindGoogleContactIntroUI.c(this.eFc));
    }
}
