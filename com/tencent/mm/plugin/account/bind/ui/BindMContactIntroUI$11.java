package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.bg.d;
import com.tencent.mm.plugin.account.a.j;

class BindMContactIntroUI$11 implements OnClickListener {
    final /* synthetic */ BindMContactIntroUI eGe;

    BindMContactIntroUI$11(BindMContactIntroUI bindMContactIntroUI) {
        this.eGe = bindMContactIntroUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intent = new Intent();
        intent.putExtra("kintent_hint", this.eGe.getString(j.settings_unbind_set_password_tip));
        intent.putExtra("from_unbind", true);
        d.b(this.eGe, "account", "com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI", intent, 1);
    }
}
