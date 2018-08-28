package com.tencent.mm.plugin.account.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.a.i;

class BindMobileStatusUI$2 implements OnClickListener {
    final /* synthetic */ BindMobileStatusUI eGW;

    BindMobileStatusUI$2(BindMobileStatusUI bindMobileStatusUI) {
        this.eGW = bindMobileStatusUI;
    }

    public final void onClick(View view) {
        boolean z = true;
        BindMobileStatusUI.a(this.eGW, Boolean.valueOf(!BindMobileStatusUI.b(this.eGW).booleanValue()));
        if (BindMobileStatusUI.b(this.eGW).booleanValue()) {
            BindMobileStatusUI.c(this.eGW).setImageResource(i.checkbox_selected);
        } else {
            BindMobileStatusUI.c(this.eGW).setImageResource(i.checkbox_unselected);
        }
        BindMobileStatusUI bindMobileStatusUI = this.eGW;
        if (BindMobileStatusUI.b(this.eGW).booleanValue()) {
            z = false;
        }
        BindMobileStatusUI.a(bindMobileStatusUI, z, 512, 8);
    }
}
