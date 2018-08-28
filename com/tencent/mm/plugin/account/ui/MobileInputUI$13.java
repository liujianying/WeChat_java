package com.tencent.mm.plugin.account.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.account.a.a;

class MobileInputUI$13 implements OnClickListener {
    final /* synthetic */ MobileInputUI eTe;

    MobileInputUI$13(MobileInputUI mobileInputUI) {
        this.eTe = mobileInputUI;
    }

    public final void onClick(View view) {
        d.A(this.eTe, "login_exdevice", ".ui.LoginAsExDeviceUI");
        this.eTe.overridePendingTransition(a.push_down_in, a.anim_not_change);
    }
}
