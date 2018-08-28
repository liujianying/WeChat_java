package com.tencent.mm.plugin.account.security.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.bind.ui.BindMContactUI;
import com.tencent.mm.ui.MMWizardActivity;

class BindSafeDeviceUI$2 implements OnClickListener {
    final /* synthetic */ BindSafeDeviceUI eOw;

    BindSafeDeviceUI$2(BindSafeDeviceUI bindSafeDeviceUI) {
        this.eOw = bindSafeDeviceUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("is_bind_for_safe_device", true);
        intent.setClass(this.eOw, BindMContactUI.class);
        MMWizardActivity.D(this.eOw, intent);
    }
}
