package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.ui.BindFacebookUI.a;

class BindFacebookUI$3 implements OnClickListener {
    final /* synthetic */ BindFacebookUI ePD;

    BindFacebookUI$3(BindFacebookUI bindFacebookUI) {
        this.ePD = bindFacebookUI;
    }

    public final void onClick(View view) {
        BindFacebookUI.c(this.ePD).a(this.ePD, FacebookAuthUI.eQb, new a(this.ePD, (byte) 0));
    }
}
