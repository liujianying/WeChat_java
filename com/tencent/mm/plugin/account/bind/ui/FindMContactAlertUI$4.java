package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;

class FindMContactAlertUI$4 implements OnClickListener {
    final /* synthetic */ FindMContactAlertUI eHH;

    FindMContactAlertUI$4(FindMContactAlertUI findMContactAlertUI) {
        this.eHH = findMContactAlertUI;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        g.Ei().DT().set(12322, Boolean.valueOf(false));
        StringBuilder stringBuilder = new StringBuilder();
        g.Eg();
        stringBuilder = stringBuilder.append(a.DA()).append(",").append(this.eHH.getClass().getName()).append(",R300_200_phone,");
        g.Eg();
        com.tencent.mm.plugin.c.a.pV(stringBuilder.append(a.gd("R300_200_phone")).append(",2").toString());
        FindMContactAlertUI.d(this.eHH);
    }
}
