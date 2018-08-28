package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.account.a.a;

class BindMobileUI$6 implements OnClickListener {
    final /* synthetic */ BindMobileUI eHg;

    BindMobileUI$6(BindMobileUI bindMobileUI) {
        this.eHg = bindMobileUI;
    }

    public final void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("country_name", BindMobileUI.f(this.eHg));
        intent.putExtra("couttry_code", BindMobileUI.g(this.eHg));
        a.ezn.b(intent, this.eHg);
    }
}
