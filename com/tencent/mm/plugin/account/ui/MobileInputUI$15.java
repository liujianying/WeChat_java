package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.sdk.platformtools.w;

class MobileInputUI$15 implements OnClickListener {
    final /* synthetic */ MobileInputUI eTe;

    MobileInputUI$15(MobileInputUI mobileInputUI) {
        this.eTe = mobileInputUI;
    }

    public final void onClick(View view) {
        MobileInputUI.Q(this.eTe, this.eTe.getString(j.login_forget_password_help) + w.chP());
    }
}
