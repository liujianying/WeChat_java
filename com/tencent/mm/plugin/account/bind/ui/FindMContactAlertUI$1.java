package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.c.a;

class FindMContactAlertUI$1 implements OnClickListener {
    final /* synthetic */ FindMContactAlertUI eHH;

    FindMContactAlertUI$1(FindMContactAlertUI findMContactAlertUI) {
        this.eHH = findMContactAlertUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.Ei().DT().set(12322, Boolean.valueOf(true));
        a.pU("R200_100");
        Intent intent = new Intent();
        intent.putExtra("mobile_input_purpose", 4);
        intent.putExtra("regsetinfo_ticket", FindMContactAlertUI.a(this.eHH));
        intent.putExtra("regsetinfo_NextStep", FindMContactAlertUI.b(this.eHH));
        intent.putExtra("regsetinfo_NextStyle", FindMContactAlertUI.c(this.eHH));
        com.tencent.mm.plugin.account.a.a.ezn.a(this.eHH, intent);
        a.pU("R300_300_phone");
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(com.tencent.mm.kernel.a.DA()).append(",").append(this.eHH.getClass().getName()).append(",R300_200_phone,");
        g.Eg();
        a.d(false, stringBuilder.append(com.tencent.mm.kernel.a.gd("R300_200_phone")).append(",2").toString());
    }
}
