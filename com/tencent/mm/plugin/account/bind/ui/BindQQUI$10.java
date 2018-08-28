package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.account.a.j;

class BindQQUI$10 implements OnClickListener {
    final /* synthetic */ BindQQUI eHn;

    BindQQUI$10(BindQQUI bindQQUI) {
        this.eHn = bindQQUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.putExtra("kintent_hint", this.eHn.getString(j.settings_unbind_set_password_tip));
        intent.putExtra("from_unbind", true);
        d.b(this.eHn, "account", "com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI", intent, 1);
    }
}
