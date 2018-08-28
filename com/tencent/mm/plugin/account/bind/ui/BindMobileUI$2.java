package com.tencent.mm.plugin.account.bind.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.plugin.account.a.j;
import com.tencent.mm.sdk.platformtools.bi;

class BindMobileUI$2 implements OnClickListener {
    final /* synthetic */ BindMobileUI eHg;

    BindMobileUI$2(BindMobileUI bindMobileUI) {
        this.eHg = bindMobileUI;
    }

    public final void onClick(View view) {
        if (BindMobileUI.a(this.eHg).getText().toString() == null || BindMobileUI.a(this.eHg).getText().toString().length() == 0) {
            Toast.makeText(this.eHg, this.eHg.getString(j.bind_mcontact_err_format), 0).show();
            return;
        }
        BindMobileUI.b(this.eHg, BindMobileUI.b(this.eHg).getText().toString().trim() + bi.Fx(BindMobileUI.a(this.eHg).getText().toString()));
        BindMobileUI.c(this.eHg, BindMobileUI.c(this.eHg));
    }
}
