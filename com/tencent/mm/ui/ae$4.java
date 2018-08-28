package com.tencent.mm.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mm.be.a;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;

class ae$4 implements OnClickListener {
    final /* synthetic */ CheckBox oME;
    final /* synthetic */ ae tpM;

    ae$4(ae aeVar, CheckBox checkBox) {
        this.tpM = aeVar;
        this.oME = checkBox;
    }

    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.oME != null) {
            au.HU();
            c.DT().set(4104, Boolean.valueOf(!this.oME.isChecked()));
        }
        LauncherUI cpQ = LauncherUI.cpQ();
        if (cpQ != null) {
            cpQ.tkn.tjF.ZS("tab_find_friend");
        }
        a.eF(ae.c(this.tpM));
    }
}
