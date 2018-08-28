package com.tencent.mm.plugin.account.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;

class RegByMobileRegAIOUI$10 implements OnClickListener {
    final /* synthetic */ RegByMobileRegAIOUI eVb;

    RegByMobileRegAIOUI$10(RegByMobileRegAIOUI regByMobileRegAIOUI) {
        this.eVb = regByMobileRegAIOUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(a.DA()).append(",").append(this.eVb.getClass().getName()).append(",RE200_200,");
        g.Eg();
        com.tencent.mm.plugin.c.a.d(false, stringBuilder.append(a.gd("RE200_200")).append(",2").toString());
        com.tencent.mm.plugin.c.a.pU("RE200_100");
    }
}
